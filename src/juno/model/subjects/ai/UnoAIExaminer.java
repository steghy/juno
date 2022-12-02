/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.model.subjects.ai;

import juno.model.util.MyRandom;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simone Gentili
 */
public class UnoAIExaminer
        extends AbstractUnoExaminer<InterfaceUnoCard>
        implements InterfaceUnoExaminer<InterfaceUnoCard> {

    private List<InterfaceUnoCard> compatibleCards;
    private List<InterfaceUnoCard> numericCards;
    private List<InterfaceUnoCard> actionCards;
    private List<InterfaceUnoCard> jollyCards;

    /* The UnoAIExaminer instance */
    private static UnoAIExaminer instance;

    /* Builds the UnoAIExaminer instance */
    private UnoAIExaminer() {}

    /**
     * Returns the UnoAIExaminer instance.
     * @return The UnoAIExaminer instance.
     */
    public static UnoAIExaminer getInstance() {
        if(instance == null) instance = new UnoAIExaminer();
        return instance;
    }

    @Override
    public InterfaceUnoCard responseRelativeTo(@NotNull List<InterfaceUnoCard> items,
                                               @NotNull Difficulty difficulty) {
        compatibleCards = getCompatibleItemsProvider().getCompatibleItems(items);
        if(compatibleCards.size() == 0) {
            return null;
        } if(compatibleCards.size() == 1) {
            return compatibleCards.get(0);
        } else {
            setCards();
            if(difficulty == Difficulty.EASY) {
                return easy();
            } if(difficulty == Difficulty.MEDIUM) {
                return medium();
            } if(difficulty == Difficulty.HARD) {
                return hard();
            } else {
                throw new IllegalArgumentException("Unsupported Difficulty object: " + difficulty);
            }
        }
    }

    private InterfaceUnoCard easy() {
        if(numericCards.size() != 0) {
            return randomNumericCard();
        } if(actionCards.size() != 0) {
            return randomActionCard();
        } if(jollyCards.size() != 0) {
            return randomJollyCard();
        } else {
            throw new IllegalArgumentException("Unavailable cards to play");
        }
    }

    private InterfaceUnoCard medium() {
        if(actionCards.size() != 0) {
            return randomActionCard();
        } if(numericCards.size() != 0) {
            return randomNumericCard();
        } if(jollyCards.size() != 0) {
            return randomJollyCard();
        } else {
            throw new IllegalArgumentException("Unavailable cards to play");
        }
    }

    private InterfaceUnoCard hard() {
        if(jollyCards.size() != 0) {
            return randomJollyCard();
        } if(actionCards.size() != 0) {
            return randomActionCard();
        } if(numericCards.size() != 0) {
            return randomNumericCard();
        } else {
            throw new IllegalArgumentException("Unavailable cards to play");
        }
    }

    private InterfaceUnoCard randomNumericCard() {
        return numericCards.get(MyRandom.getInstance().nextInt(numericCards.size()));
    }

    private InterfaceUnoCard randomActionCard() {
        return actionCards.get(MyRandom.getInstance().nextInt(actionCards.size()));
    }

    private InterfaceUnoCard randomJollyCard() {
        return jollyCards.get(MyRandom.getInstance().nextInt(jollyCards.size()));
    }

    private void setCards() {
        numericCards = new ArrayList<>();
        actionCards = new ArrayList<>();
        jollyCards = new ArrayList<>();
        compatibleCards.forEach(card -> {
            if (card != null) {
                if (card.value() != null) {
                    numericCards.add(card);
                } else if (card.action() != null) {
                    if (card.action().isWildAction() || card.action().isWildDrawFourAction()) {
                        jollyCards.add(card);
                    } else {
                        actionCards.add(card);
                    }
                }
            }
        });
    }
}
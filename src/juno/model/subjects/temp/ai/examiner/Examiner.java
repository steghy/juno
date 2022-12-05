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

package juno.model.subjects.temp.ai.examiner;

import juno.model.card.InterfaceCard;
import juno.model.subjects.temp.ai.Difficulty;
import juno.model.util.MyRandom;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simone Gentili
 */
public class Examiner
        extends AbstractExaminer<InterfaceCard>
        implements InterfaceExaminer<InterfaceCard> {

    // Compatible cards.
    private List<InterfaceCard> compatibleCards;

    // Numeric cards.
    private List<InterfaceCard> numericCards;

    // Action cards.
    private List<InterfaceCard> actionCards;

    // Jolly cards.
    private List<InterfaceCard> jollyCards;

    // The Examiner instance.
    private static Examiner instance;

    // Builds the Examiner instance.
    private Examiner() {}

    /**
     * Returns the Examiner instance.
     * @return The Examiner instance.
     */
    public static Examiner getInstance() {
        if(instance == null) instance = new Examiner();
        return instance;
    }

    @Override @Nullable
    public InterfaceCard responseRelativeTo(@NotNull List<InterfaceCard> items,
                                            @NotNull Difficulty difficulty) {
        compatibleCards = getItemsProvider().getCompatibleItems(items);
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

    private InterfaceCard easy() {
        if(numericCards.size() != 0) {
            return randomNumberCard();
        } if(actionCards.size() != 0) {
            return randomActionCard();
        } if(jollyCards.size() != 0) {
            return randomJollyCard();
        } else {
            throw new IllegalArgumentException("Unavailable cards to play");
        }
    }

    private InterfaceCard medium() {
        if(actionCards.size() != 0) {
            return randomActionCard();
        } if(numericCards.size() != 0) {
            return randomNumberCard();
        } if(jollyCards.size() != 0) {
            return randomJollyCard();
        } else {
            throw new IllegalArgumentException("Unavailable cards to play");
        }
    }

    private InterfaceCard hard() {
        if(jollyCards.size() != 0) {
            return randomJollyCard();
        } if(actionCards.size() != 0) {
            return randomActionCard();
        } if(numericCards.size() != 0) {
            return randomNumberCard();
        } else {
            throw new IllegalArgumentException("Unavailable cards to play");
        }
    }

    // Choose a random card from the number cards.
    private InterfaceCard randomNumberCard() {
        return numericCards.get(MyRandom.getInstance().nextInt(numericCards.size()));
    }

    // Choose a random card from the action cards.
    private InterfaceCard randomActionCard() {
        return actionCards.get(MyRandom.getInstance().nextInt(actionCards.size()));
    }

    // Choose a random card from the jolly cards.
    private InterfaceCard randomJollyCard() {
        return jollyCards.get(MyRandom.getInstance().nextInt(jollyCards.size()));
    }

    // Organize the cards according to their attributes.
    private void setCards() {
        numericCards = new ArrayList<>();
        actionCards = new ArrayList<>();
        jollyCards = new ArrayList<>();
        // Checking cards type.
        compatibleCards.forEach(card -> {
            if (card != null) {
                // Numerical case.
                if (card.value() != null) {
                    numericCards.add(card);
                } else if (card.action() != null) {
                    // Jolly case.
                    if (card.action().isJolly()) {
                        jollyCards.add(card);
                    } else {
                        // Action case.
                        actionCards.add(card);
                    }
                }
            }
        });
    }
}
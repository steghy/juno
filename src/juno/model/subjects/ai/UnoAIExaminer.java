package juno.model.subjects.ai;

import juno.model.card.*;
import juno.model.util.MyRandom;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class UnoAIExaminer
        extends AbstractUnoExaminer<InterfaceUnoCard> {

    private List<InterfaceUnoCard> compatibleCards;
    private List<InterfaceUnoCard> numericCards;
    private List<InterfaceUnoCard> actionCards;
    private List<InterfaceUnoCard> jollyCards;
    private static UnoAIExaminer instance;

    private UnoAIExaminer() {}

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
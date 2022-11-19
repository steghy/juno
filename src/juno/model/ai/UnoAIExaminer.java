package juno.model.ai;

import juno.model.card.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UnoAIExaminer extends AbstractUnoExaminer<AbstractUnoCard> {

    private List<AbstractUnoCard> compatibleCards;
    private List<AbstractUnoCard> numericCards;
    private List<AbstractUnoCard> actionCards;
    private List<AbstractUnoCard> jollyCards;
    private final Random random;
    private static UnoAIExaminer instance;

    private UnoAIExaminer() {
        random = new Random();
    }

    public static UnoAIExaminer getInstance() {
        if(instance == null) {
            instance = new UnoAIExaminer();
        } return instance;
    }

    @Override
    public AbstractUnoCard responseRelativeTo(@NotNull List<AbstractUnoCard> items,@NotNull Difficulty difficulty) {
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

    private AbstractUnoCard easy() {
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

    private AbstractUnoCard medium() {
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

    private AbstractUnoCard hard() {
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

    private AbstractUnoCard randomNumericCard() {
        return numericCards.get(random.nextInt(numericCards.size()));
    }

    private AbstractUnoCard randomActionCard() {
        return actionCards.get(random.nextInt(actionCards.size()));
    }

    private AbstractUnoCard randomJollyCard() {
        return jollyCards.get(random.nextInt(jollyCards.size()));
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

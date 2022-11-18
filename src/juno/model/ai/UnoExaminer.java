package juno.model.ai;

import juno.model.card.*;

import java.util.List;

public class UnoExaminer<T> extends AbstractUnoExaminer<
        T,
        AbstractUnoCard<
                AbstractUnoCardAction,
                AbstractUnoCardColor<AbstractUnoColor>,
                AbstractUnoCardValue>> {

    private Difficulty difficulty;
    private List<AbstractUnoCard<
                    AbstractUnoCardAction,
                    AbstractUnoCardColor<AbstractUnoColor>,
                    AbstractUnoCardValue>> playableCards;

    public UnoExaminer(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public AbstractUnoCard<
            AbstractUnoCardAction,
            AbstractUnoCardColor<AbstractUnoColor>,
            AbstractUnoCardValue> response() {
        setPlayableCards();
        if(playableCards.size() == 1) {
            return playableCards.get(0);
        } else if(playableCards.size() == 0) {
            return null;
        } else if(difficulty == Difficulty.EASY) {
            return easy();
        } else if(difficulty ==  Difficulty.MEDIUM) {
            return medium();
        } else if(difficulty == Difficulty.HARD) {
            return hard();
        } else {
            throw new IllegalArgumentException("Invalid Difficulty: " + difficulty);
        }
    }

    private AbstractUnoCard<
             AbstractUnoCardAction,
             AbstractUnoCardColor<AbstractUnoColor>,
             AbstractUnoCardValue> easy(){
        return null;
    }

    private AbstractUnoCard<
            AbstractUnoCardAction,
            AbstractUnoCardColor<AbstractUnoColor>,
            AbstractUnoCardValue> medium(){
        return null;
    }

    private AbstractUnoCard<
            AbstractUnoCardAction,
            AbstractUnoCardColor<AbstractUnoColor>,
            AbstractUnoCardValue> hard(){
        return null;
    }

    private void setPlayableCards(){
        if(getCompatibleItemsProvider() != null) {
            playableCards = getCompatibleItemsProvider()
                    .getCompatibleItems(getHandsManager()
                            .getItemsOf(getSubjectsManager()
                                    .currentSubject()));
        } else {
            throw new IllegalArgumentException("CompatibleItemsProvider is null");
        }
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
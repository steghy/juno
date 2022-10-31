package juno.model.deck;

import java.util.Stack;

/**
 * @author steghy
 */
class DiscardedPileComponent<T> extends Stack<T> implements AbstractDiscardPile<T> {

    /* The DiscardedCards instance */
    private static DiscardedPileComponent<?> instance;

    private DiscardedPileComponent() {}

    /**
     * Returns the DiscardedCards instance
     * @return The DiscardedCards instance
     */
    static DiscardedPileComponent<?> getInstance(){
        if(instance == null){
            instance = new DiscardedPileComponent<>();
        } return instance;
    }

    @Override
    public void discard(T card){
        this.push(card);
    }
}
package juno.model.deck;

import juno.model.card.AbstractUnoCard;

/**
 * @author steghy
 */
public class UnoDeckManager implements AbstractUnoDeckManager {

    /* The UnoDeckManager instance */
    private static UnoDeckManager instance;

    /* Builds the UnoDeckManager instance */
    private UnoDeckManager() {}

    /**
     * Returns the UnoDeckManager instance
     * @return The UnoDeckManager instance
     */
    public static UnoDeckManager getInstance(){
       if(instance == null){
           instance = new UnoDeckManager();
       } return instance;
    }

    @Override
    public void reintroduceCards(AbstractUnoDeck<AbstractUnoCard> deck,
                                 AbstractUnoDiscardedCards<AbstractUnoCard> discardedCards) {
        int lastIndex = discardedCards.size() - 1;
        AbstractUnoCard lastItem = discardedCards.get(lastIndex);
        discardedCards.remove(lastIndex);
        deck.addAll(discardedCards);
        discardedCards.clear();
        discardedCards.put(lastItem);
    }
}

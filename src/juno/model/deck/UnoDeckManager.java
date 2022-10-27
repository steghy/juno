package juno.model.deck;

import juno.model.card.AbstractUnoCard;

/**
 * @author steghy
 */
public class UnoDeckManager implements AbstractUnoDeckManager {

    @Override
    public void reintroduceCards(AbstractUnoDeck deck, AbstractUnoDiscardedCards discardedCards) {
        int lastIndex = discardedCards.size() - 1;
        Object lastItem = discardedCards.get(lastIndex);
        discardedCards.remove(lastIndex);
        deck.addAll(discardedCards);
        discardedCards.clear();
        discardedCards.put(lastItem);
    }
}

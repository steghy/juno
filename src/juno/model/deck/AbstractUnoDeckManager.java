package juno.model.deck;

import juno.model.card.AbstractUnoCard;

public interface AbstractUnoDeckManager {

    void reintroduceCards(AbstractUnoDeck<AbstractUnoCard> deck,
                          AbstractUnoDiscardedCards<AbstractUnoCard> discardedCards);
}

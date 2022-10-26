package juno.model.deck;

import juno.model.card.AbstractUnoCard;

public interface AbstractDiscardedDeck {

    void put(AbstractUnoCard card) throws IllegalArgumentException;
}

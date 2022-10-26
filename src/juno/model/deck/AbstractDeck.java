package juno.model.deck;

import juno.model.deck.exceptions.DeckIsEmptyException;

public interface AbstractDeck<E> {

    E draw() throws DeckIsEmptyException;

}

package juno.model.deck;

import juno.model.deck.exceptions.DeckIsEmptyException;
import java.util.List;

public interface AbstractDeck<E> extends List<E> {

    E draw() throws DeckIsEmptyException;
}

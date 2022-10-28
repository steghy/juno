package juno.model.deck;

import java.util.List;

public interface AbstractDeck<E> extends List<E> {

    E draw() throws IllegalArgumentException;

}

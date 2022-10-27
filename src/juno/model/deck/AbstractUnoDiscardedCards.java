package juno.model.deck;

import java.util.List;

public interface AbstractUnoDiscardedCards<E> extends List<E> {

    void put(E el) throws IllegalArgumentException;
}

package juno.model.deck;

import java.util.List;

public interface AbstractDiscardedCards<E> {

    void put(E el) throws IllegalArgumentException;
}

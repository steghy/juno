package juno.model.deck;

import java.util.List;

public interface AbstractDiscardPile<E> extends List<E> {

    void discard(E el) throws IllegalArgumentException;
}

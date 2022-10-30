package juno.model.deck;

import java.util.List;

public interface AbstractDiscardPile<T> extends List<T> {

    void discard(T el) throws IllegalArgumentException;
}

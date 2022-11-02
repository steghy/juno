package juno.model.deck;

import java.util.List;

public interface InterfaceDiscardedPile<T> {

    void discard(T item);

    T lastItem();

    void clear();

    List<T> items();
}

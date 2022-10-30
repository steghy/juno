package juno.model.deck;

public interface AbstractUnoDeck<T> {

    T draw();

    void discard(T item);

    T getLastCardDrawn();

    T getLastCardInserted();
}

package juno.model.deck;

public interface AbstractDiscardedCards<E> {

    void put(E el) throws IllegalArgumentException;
}

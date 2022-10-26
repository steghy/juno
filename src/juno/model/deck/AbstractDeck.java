package juno.model.deck;

public interface AbstractDeck<E> {

    E draw() throws IllegalArgumentException;

}

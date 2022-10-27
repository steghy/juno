package juno.model.deck;

import java.util.List;

public interface AbstractUnoDeck<E> extends List<E> {

    E draw() throws IllegalArgumentException;

}

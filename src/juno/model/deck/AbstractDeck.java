package juno.model.deck;

import java.util.List;

public interface AbstractDeck<T> extends List<T> {

    T draw() throws IllegalArgumentException;

}

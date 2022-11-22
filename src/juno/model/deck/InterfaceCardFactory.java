package juno.model.deck;

import java.util.Collection;

public interface InterfaceCardFactory<T> {

    Collection<T> getCards();
}

package juno.model.deck;

import java.util.Collection;

public interface InterfaceDeckFactory<T> {

    Collection<T> getDeck();
}

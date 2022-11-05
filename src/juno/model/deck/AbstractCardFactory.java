package juno.model.deck;

import java.util.Collection;

public interface AbstractCardFactory<T> {

    Collection<T> getCards();
}

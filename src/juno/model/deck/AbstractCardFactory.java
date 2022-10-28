package juno.model.deck;

import java.util.Collection;

public interface AbstractCardFactory<E> {

    Collection<E> getCards();
}

package juno.model.deck;

import java.util.Collection;

/**
 * This interface defines cards factory.
 * @param <T> The items type.
 */
public interface AbstractCardFactory<T> {

    /**
     * Returns a Collection of T items.
     * @return A Collection<T>.
     */
    Collection<T> getCards();
}

package juno.model.deck;

import java.util.List;

/**
 * This class defines deck refiller.
 * @param <T> The items type
 */
public interface AbstractDeckRefiller<T> {

    /**
     * Add all the elements contained in the second List
     * into the first List, then clear the second List.
     * @param deckToSupply The deck to refill.
     * @param deckSupplier The supplier deck.
     */
    void refill(List<T> deckToSupply, List<T> deckSupplier);
}

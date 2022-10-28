package juno.model.deck;

import java.util.List;

public interface AbstractDeckRefiller<E> {

    void refill(List<E> deckToSupply, List<E> deckSupplier);
}

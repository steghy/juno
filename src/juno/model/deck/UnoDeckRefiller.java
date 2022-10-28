package juno.model.deck;


import java.util.List;

/**
 * @author steghy
 */
public class UnoDeckRefiller<E> implements AbstractDeckRefiller<E> {

    @Override
    public void refill(List<E> deckToSupply, List<E> deckSupplier) {
        if(deckSupplier.size() < 1) {
            throw new IllegalArgumentException("invalid supplier deck size");
        }

        int lastIndex = deckSupplier.size() - 1;
        E lastItem = deckSupplier.get(lastIndex);
        deckSupplier.remove(lastIndex);
        deckToSupply.addAll(deckSupplier);
        deckSupplier.clear();
        deckSupplier.add(lastItem);
    }
}
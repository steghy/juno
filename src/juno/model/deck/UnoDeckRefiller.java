package juno.model.deck;


import java.util.List;

/**
 * @author steghy
 */
public class UnoDeckRefiller<T> implements AbstractDeckRefiller<T>  {

    /* The DeckRefiller instance */
    private static UnoDeckRefiller<?> instance;

    /* Builds the DeckRefiller instance */
    private UnoDeckRefiller() {}

    /**
     * Returns the DeckRefiller instance.
     * @return The DeckRefiller instance.
     */
    public static UnoDeckRefiller<?> getInstance() {
        if(instance == null) {
            instance = new UnoDeckRefiller<>();
        } return instance;
    }
    @Override
    public void refill(List<T> deckToSupply, List<T> deckSupplier) {

        if(deckSupplier.size() < 1) {
            throw new IllegalArgumentException("invalid supplier deck size");
        }

        int lastIndex = deckSupplier.size() - 1;
        T lastItem = deckSupplier.get(lastIndex);
        deckSupplier.remove(lastIndex);
        deckToSupply.addAll(deckSupplier);
        deckSupplier.clear();
        deckSupplier.add(lastItem);
    }
}
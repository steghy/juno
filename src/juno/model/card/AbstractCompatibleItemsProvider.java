package juno.model.card;

import juno.model.deck.InterfaceCompatibilityChecker;
import juno.model.deck.InterfaceDiscardedPile;

public abstract class AbstractCompatibleItemsProvider<T> implements InterfaceCompatibleItemsProvider<T> {

    private InterfaceCompatibilityChecker<T> compatibilityChecker;
    private InterfaceDiscardedPile<T> discardedPile;

    public void setCompatibilityChecker(InterfaceCompatibilityChecker<T> compatibilityChecker) {
        this.compatibilityChecker = compatibilityChecker;
    }

    public void setDiscardedPile(InterfaceDiscardedPile<T> discardedPile) {
        this.discardedPile = discardedPile;
    }

    public InterfaceCompatibilityChecker<T> getCompatibilityChecker() {
        return compatibilityChecker;
    }

    public InterfaceDiscardedPile<T> getDiscardedPile() {
        return discardedPile;
    }
}

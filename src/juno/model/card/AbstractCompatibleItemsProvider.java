package juno.model.card;

import juno.model.deck.AbstractCompatibilityChecker;
import juno.model.deck.InterfaceDiscardedPile;

public abstract class AbstractCompatibleItemsProvider<T> implements InterfaceCompatibleItemsProvider<T> {

    private AbstractCompatibilityChecker<T> compatibilityChecker;
    private InterfaceDiscardedPile<T> discardedPile;

    public void setCompatibilityChecker(AbstractCompatibilityChecker<T> compatibilityChecker) {
        this.compatibilityChecker = compatibilityChecker;
    }

    public void setDiscardedPile(InterfaceDiscardedPile<T> discardedPile) {
        this.discardedPile = discardedPile;
    }

    public AbstractCompatibilityChecker<T> getCompatibilityChecker() {
        return compatibilityChecker;
    }

    public InterfaceDiscardedPile<T> getDiscardedPile() {
        return discardedPile;
    }
}

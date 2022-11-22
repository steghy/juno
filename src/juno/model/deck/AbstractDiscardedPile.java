package juno.model.deck;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractDiscardedPile<T>
        implements InterfaceDiscardedPile<T> {

    private InterfaceCompatibilityChecker<T> compatibilityChecker;

    public void setCompatibilityChecker(@NotNull InterfaceCompatibilityChecker<T> compatibilityChecker) {
        this.compatibilityChecker = compatibilityChecker;
    }

    public InterfaceCompatibilityChecker<T> getCompatibilityChecker() {
        return this.compatibilityChecker;
    }

}

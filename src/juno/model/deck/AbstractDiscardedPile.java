package juno.model.deck;

public abstract class AbstractDiscardedPile<T> implements InterfaceDiscardedPile<T> {

    private AbstractCompatibilityChecker<T> compatibilityChecker;

    public void setCompatibilityChecker(AbstractCompatibilityChecker<T> compatibilityChecker) {
        this.compatibilityChecker = compatibilityChecker;
    }

    public AbstractCompatibilityChecker<T> getCompatibilityChecker() {
        return this.compatibilityChecker;
    }

}

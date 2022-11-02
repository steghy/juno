package juno.model.deck;

import java.util.List;

public abstract class AbstractDiscardedPile<T> implements InterfaceDiscardedPile<T> {

    private AbstractCompatibilityChecker<T> compatibilityChecker;

    /**
     * Sets the AbstractCompatibilityChecker object of this instance.
     * @param compatibilityChecker An AbstractCompatibilityChecker object.
     */
    public void setCompatibilityChecker(AbstractCompatibilityChecker<T> compatibilityChecker) {
        this.compatibilityChecker = compatibilityChecker;
    }

    /**
     * Returns the AbstractCompatibilityChecker object of this instance.
     * @return An AbstractCompatibilityChecker object.
     */
    public AbstractCompatibilityChecker<T> getCompatibilityChecker() {
        return this.compatibilityChecker;
    }

}

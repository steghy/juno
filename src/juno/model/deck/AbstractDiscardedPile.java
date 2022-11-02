package juno.model.deck;

import java.util.List;

public abstract class AbstractDiscardedPile<T> {

    private AbstractCompatibilityChecker<T> compatibilityChecker;

    public abstract void discard(T item);

    public abstract int size();

    public abstract T lastCard();

    public abstract void clear();

    public abstract List<T> items();

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

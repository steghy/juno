package juno.model.deck;

/**
 * This interface defines a compatibility
 * checker.
 * @param <T> The items type.
 */
public interface AbstractCompatibilityChecker<T> {

    /**
     * Returns true if, and only if, the specified
     * items are compatible.
     * @param el1 An object of type T.
     * @param el2 An object of type T.
     * @return A boolean.
     */
    boolean areCompatible(T el1, T el2);
}

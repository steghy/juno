package juno.model.deck;

public interface AbstractCompatibilityChecker<T> {

    boolean areCompatible(T el1, T el2);
}

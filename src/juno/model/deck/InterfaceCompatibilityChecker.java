package juno.model.deck;

public interface InterfaceCompatibilityChecker<T> {

    boolean areCompatible(T el1, T el2);
}

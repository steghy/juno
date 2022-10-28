package juno.model.deck;

public interface AbstractCompatibilityChecker<E> {

    boolean areCompatible(E el1, E el2);
}

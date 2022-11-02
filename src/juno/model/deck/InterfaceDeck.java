package juno.model.deck;

public interface InterfaceDeck<T> {

    T draw();

    T lastItem();

    void generate();
}

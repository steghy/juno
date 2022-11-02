package juno.model.player;

public interface InterfaceShiftManager<T> {

    void next();

    T current();

    void invert();

    void setFirst(T subject);
}

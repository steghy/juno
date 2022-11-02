package juno.model.player;

public interface InterfaceHandsManager<T, E> {

    void addItem(T subject, E item);

    void removeItemTo(T subject, E item);
}

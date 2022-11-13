package juno.model.player.hands;

public interface AbstractItemAdder<T, E> {

    void addItemTo(T subject, E item);
}

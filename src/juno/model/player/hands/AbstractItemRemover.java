package juno.model.player.hands;

public interface AbstractItemRemover<T, E> {

    void removeItemTo(T subject, E item);
}

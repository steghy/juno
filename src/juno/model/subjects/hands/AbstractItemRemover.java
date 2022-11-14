package juno.model.subjects.hands;

public interface AbstractItemRemover<T, E> {

    void removeItemTo(T subject, E item);
}

package juno.model.subjects.hands;

public interface AbstractItemAdder<T, E> {

    void addItemTo(T subject, E item);
}

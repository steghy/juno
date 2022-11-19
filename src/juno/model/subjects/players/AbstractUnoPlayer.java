package juno.model.subjects.players;

import juno.model.subjects.factory.AbstractSubject;

public interface AbstractUnoPlayer<T> extends AbstractSubject {

    void addItem(T item);

    void removeItem(T item);
}

package juno.model.subjects.players;

import juno.model.subjects.factory.InterfaceSubject;

public interface InterfaceUnoPlayer<T> extends InterfaceSubject {

    void addItem(T item);

    void removeItem(T item);
}
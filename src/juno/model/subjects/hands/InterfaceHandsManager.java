package juno.model.subjects.hands;

import java.util.List;

public interface InterfaceHandsManager<T, E> {

    List<E> getItemsOf(T subject);
}

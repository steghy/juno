package juno.model.subjects.hands;

import java.util.List;

public interface AbstractHandsManager<T, E> {

    List<E> getItemsOf(T subject);
}

package juno.model.player.hands;

import java.util.Collection;

public interface AbstractHandsManager<T, E> {

    void addItem(T subject, E item);

    void removeItemTo(T subject, E item);

    Collection<E> getItemsOf(T subject);
}

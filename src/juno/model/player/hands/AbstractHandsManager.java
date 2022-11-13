package juno.model.player.hands;

import java.util.Collection;

public interface AbstractHandsManager<T, E> {

    Collection<E> getItemsOf(T subject);
}

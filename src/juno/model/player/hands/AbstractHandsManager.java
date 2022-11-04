package juno.model.player.hands;

import java.util.List;

public interface AbstractHandsManager<T, E> {

    void addItem(T subject, E item);

    void removeItemTo(T subject, E item);

    List<E> getCardsOf(T subject);
}

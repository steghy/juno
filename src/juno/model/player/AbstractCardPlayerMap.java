package juno.model.player;

import java.util.List;
import java.util.Map;

public interface AbstractCardPlayerMap<T, E> extends Map<T, E> {

    List<E> getCardsOf(T player);

    void addCardTo(T player, E card);

    void removeCardTo(T player, E card);

}

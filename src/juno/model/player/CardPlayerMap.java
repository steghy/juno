package juno.model.player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardPlayerMap<T, E> extends HashMap<T, E> implements AbstractCardPlayerMap<T, E> {

    private Map<T, List<E>> cardPlayerMap;

    @Override
    public List<E> getCardsOf(T player) {
        if(cardPlayerMap.containsKey(player)) {
            return cardPlayerMap.get(player);
        } else {
            throw new IllegalArgumentException("Invalid player");
        }
    }

    @Override
    public void addCardTo(T player, E card) {
        if(cardPlayerMap.containsKey(player)) {
            cardPlayerMap.get(player).add(card);
        } else {
            throw new IllegalArgumentException("Invalid player");
        }
    }

    @Override
    public void removeCardTo(T player, E card) {
        if(cardPlayerMap.containsKey(player)) {
            cardPlayerMap.get(player).remove(card);
        } else {
            throw new IllegalArgumentException("Invalid player");
        }
    }
}

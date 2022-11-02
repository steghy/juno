package juno.model.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractHandsManager<T, E> implements InterfaceHandsManager<T, E> {

    private Map<T, List<E>> hands;
    private InterfacePlayerFactory<T> playerFactory;

    /**
     * Initialize the hand (List<E>) of the players of type T.
     */
    public void initializeHands() {
        if(playerFactory != null) {
            hands = new HashMap<>();
            playerFactory.getPlayers().forEach(player -> {
                hands.put(player, new ArrayList<E>());
            });
        }
    }

    /**
     * Returns the hand (List<E>) of the players of
     * type T.
     * @return A Map object.
     */
    public Map<T, List<E>> getHands() {
        return hands;
    }

    /**
     * Clear the hands map.
     */
    public void clear() {
        if(hands != null) {
            hands.clear();
        } else {
            throw new IllegalArgumentException("HandsMap isn't initialized");
        }
    }

    /**
     * Sets the InterfacePlayerFactory object of this instance.
     * @param playerFactory An InterfacePlayerFactory object.
     */
    public void setPlayerFactory(InterfacePlayerFactory<T> playerFactory) {
        this.playerFactory = playerFactory;
    }

    /**
     * Returns the InterfacePlayerFactory of this instance.
     * @return An InterfacePlayerFactory object
     */
    public InterfacePlayerFactory<T> getPlayerFactory() {
        return playerFactory;
    }
}

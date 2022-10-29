package juno.model.player;


import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author steghy
 */
public interface AbstractUnoGameData<E, T> {

    /**
     * Returns the Map that contains the AbstractPlayer
     * objects and its AbstractUnoCard objects.
     *
     * @return A Map object.
     */
    Map<E, List<T>> getGameData();

    interface AbstractPlayerFactory {

        Collection<AbstractPlayer> getPlayers();
    }
}

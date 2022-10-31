package juno.model.player;

import java.util.List;

/**
 * @author steghy
 * @param <T> The items type
 */
public abstract class AbstractPlayerFactory<T> {

    /* The AbstractNameFactory component */
    private AbstractNameFactory factory;

    /**
     * Sets the AbstractNameFactory object of this instance.
     * @param factory An AbstractNameFactory.
     */
    public void setNameFactory(AbstractNameFactory factory) {
        this.factory = factory;
    }

    /**
     * Returns the AbstractNameFactory object of this
     * instance.
     * @return An AbstractNameFactory object
     */
    public AbstractNameFactory getNameFactory() {
        return factory;
    }

    /**
     * Returns the List of players of length num + 1.
     * @param num The number of AI players.
     * @param name The name of the human player.
     * @return A List of items of type T
     */
    public abstract List<T> getPlayers(int num, String name);
}

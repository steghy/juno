package juno.model.deck;


import java.util.List;

/**
 * @author steghy
 * @param <T> The type of the items
 */
public interface AbstractMixer<T> {

    /**
     * Shuffle the specified List object
     * @param data A List object
     */
    void shuffle(List<T> data);
}

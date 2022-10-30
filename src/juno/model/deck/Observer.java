package juno.model.deck;

/**
 * Observer interface.
 * Subject-Observer desing pattern
 */
public interface Observer {

    /**
     * Update this Observer object
     * with the specified Object.
     * @param object An Object.
     */
    void update(Object object);
}

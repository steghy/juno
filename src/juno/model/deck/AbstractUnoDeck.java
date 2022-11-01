package juno.model.deck;

/**
 * @author steghy
 * @param <T> The items type
 */
public interface AbstractUnoDeck<T> {

    /**
     * Returns the top card of the deck.
     * @return The top card of the deck.
     */
    T draw();

    /**
     * Discard the specified item.
     * @param item An item of type T.
     */
    void discard(T item);

    /**
     * Returns the last card drawn.
     * @return The last card drawn.
     */
    T getLastCardDrawn();

    /**
     * Returns the last card inserted.
     * @return The last card inserted.
     */
    T getLastCardInserted();

    /**
     * Initialize this AbstractUnoDeck to play a new game.
     */
    void start();

    /**
     * Reset the entire instance
     */
    void reset();

    boolean status();
}

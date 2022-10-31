package juno.model.player;

import java.util.List;

public interface AbstractCardPlayerManager<T, E> {

    /**
     * Returns the List of the cards of the specified
     * player of type T.
     * @param player A player of type T.
     * @return A List<E>.
     */
    List<E> getCardOf(T player);

    /**
     * Adds the specified card of type E to
     * the specified player of type T.
     * @param player A player of type T.
     * @param card A card of type E.
     */
    void addCardTo(T player, E card);

    /**
     * Removes the specified card of type E
     * to the specified player of type T.
     * @param player A player of type T.
     * @param card A card of type E.
     */
    void removeCardTo(T player, E card);

    /**
     * Invert the order.
     */
    void invert();

    /**
     *  Next turn.
     */
    void next();

    /**
     * Initialize the data to play a new game.
     */
    void start(int num, String name);
}

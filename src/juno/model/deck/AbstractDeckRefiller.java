package juno.model.deck;

import java.util.List;

/**
 * This class defines deck refiller.
 * @param <T> The items type
 */
public abstract class AbstractDeckRefiller<T> {

    private AbstractDiscardedPile<T> discardedPile;

    /**
     * Refill the specified deck.
     * @param deck A List of T items.
     */
    public abstract void refill(List<T> deck);

    /**
     * Sets the AbstractDiscardedPile object of this instance.
     * @param discardedPile An AbstractDiscardedPile object
     */
    public void setDiscardedPile(AbstractDiscardedPile<T> discardedPile) {
        this.discardedPile = discardedPile;
    }

    /**
     * Returns the AbstractDiscardedPile object of this instance.
     * @return An AbstractDiscardedPile object.
     */
    public AbstractDiscardedPile<T> getDiscardedPile() {
        return discardedPile;
    }
}

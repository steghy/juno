package juno.model.deck;

import java.util.List;

/**
 * This class defines deck refiller.
 * @param <T> The items type
 */
public abstract class AbstractDeckRefiller<T> implements InterfaceDeckRefiller<T> {

    private AbstractDiscardedPile<T> discardedPile;

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

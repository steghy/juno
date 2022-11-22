package juno.model.deck;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractDeckRefiller<T>
        implements InterfaceDeckRefiller<T> {

    private AbstractDiscardedPile<T> discardedPile;

    public void setDiscardedPile(@NotNull AbstractDiscardedPile<T> discardedPile) {
        this.discardedPile = discardedPile;
    }

    public AbstractDiscardedPile<T> getDiscardedPile() {
        return discardedPile;
    }
}

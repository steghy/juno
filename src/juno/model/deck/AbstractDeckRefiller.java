package juno.model.deck;

public abstract class AbstractDeckRefiller<T> implements InterfaceDeckRefiller<T> {

    private AbstractDiscardedPile<T> discardedPile;

    public void setDiscardedPile(AbstractDiscardedPile<T> discardedPile) {
        this.discardedPile = discardedPile;
    }

    public AbstractDiscardedPile<T> getDiscardedPile() {
        return discardedPile;
    }
}

package juno.model.deck;

public abstract class AbstractDeck<T> implements InterfaceDeck<T>{

    private AbstractDeckRefiller<T> deckRefiller;
    private AbstractDeckFactory<T> deckFactory;
    private AbstractMixer<T> deckMixer;

    /**
     * Sets the AbstractDeckFactory of this instance.
     * @param deckFactory An AbstractDeckFactory object.
     */
    public void setDeckFactory(AbstractDeckFactory<T> deckFactory) {
        this.deckFactory = deckFactory;
    }

    /**
     * Sets the AbstractDeckRefiller of this instance.
     * @param deckRefiller An AbstractDeckRefiller object.
     */
    public void setDeckRefiller(AbstractDeckRefiller<T> deckRefiller) {
        this.deckRefiller = deckRefiller;
    }

    /**
     * Sets the AbstractMixer of this instance.
     * @param deckMixer An AbstractMixer object.
     */
    public void setMixer(AbstractMixer<T> deckMixer) {
        this.deckMixer = deckMixer;
    }

    /**
     * Returns the AbstractDeckFactory of this instance.
     * @return An AbstractDeckFactory object.
     */
    public AbstractDeckFactory<T> getDeckFactory() {
        return this.deckFactory;
    }

    /**
     * Returns the AbstractDeckRefiller of this instance.
     * @return An AbstractDeckRefiller object.
     */
    public AbstractDeckRefiller<T> getDeckRefiller() {
        return this.deckRefiller;
    }

    /**
     * Returns the AbstractMixer object of this instance.
     * @return An AbstractMixer object.
     */
    public AbstractMixer<T> getMixer() {
        return this.deckMixer;
    }
}

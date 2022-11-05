package juno.model.deck;

public abstract class AbstractDeck<T> implements InterfaceDeck<T>{

    private AbstractDeckRefiller<T> deckRefiller;
    private AbstractDeckFactory<T> deckFactory;
    private AbstractMixer<T> deckMixer;

    public void setDeckFactory(AbstractDeckFactory<T> deckFactory) {
        this.deckFactory = deckFactory;
    }

    public void setDeckRefiller(AbstractDeckRefiller<T> deckRefiller) {
        this.deckRefiller = deckRefiller;
    }

    public void setMixer(AbstractMixer<T> deckMixer) {
        this.deckMixer = deckMixer;
    }

    public AbstractDeckFactory<T> getDeckFactory() {
        return this.deckFactory;
    }

    public AbstractDeckRefiller<T> getDeckRefiller() {
        return this.deckRefiller;
    }

    public AbstractMixer<T> getMixer() {
        return this.deckMixer;
    }
}

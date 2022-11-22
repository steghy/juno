package juno.model.deck;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractDeck<T>
        implements InterfaceDeck<T>{

    private AbstractDeckRefiller<T> deckRefiller;
    private AbstractDeckFactory<T> deckFactory;
    private InterfaceMixer<T> deckMixer;

    public void setDeckFactory(@NotNull AbstractDeckFactory<T> deckFactory) {
        this.deckFactory = deckFactory;
    }

    public void setDeckRefiller(@NotNull AbstractDeckRefiller<T> deckRefiller) {
        this.deckRefiller = deckRefiller;
    }

    public void setMixer(@NotNull InterfaceMixer<T> deckMixer) {
        this.deckMixer = deckMixer;
    }

    public AbstractDeckFactory<T> getDeckFactory() {
        return this.deckFactory;
    }

    public AbstractDeckRefiller<T> getDeckRefiller() {
        return this.deckRefiller;
    }

    public InterfaceMixer<T> getMixer() {
        return this.deckMixer;
    }
}

package juno.model.deck;

import java.util.Stack;

public abstract class StackDeck<E> extends Stack<E> implements AbstractDeck<E> {

    private AbstractMixer<E> mixer;

    public void setMixer(AbstractMixer<E> mixer){
        this.mixer = mixer;
    }

    public AbstractMixer<E> getMixer() {
        return mixer;
    }

}

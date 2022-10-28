package juno.model.deck;


import java.util.Collection;

public abstract class AbstractDeckFactory<E> {

    private AbstractCardFactory<E> factory;

    public void setFactory(AbstractCardFactory<E> factory){
        this.factory = factory;
    }

    public AbstractCardFactory<E> getFactory(){
        return factory;
    }

    public abstract Collection<E> getDeck();
}

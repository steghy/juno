package juno.model.deck;


import java.util.Collection;

/**
 * This abstract class defines deck factories.
 * @param <T> The items type.
 */
public abstract class AbstractDeckFactory<T> {

    /**
     * An AbstractCardFactory object.
     */
    private AbstractCardFactory<T> factory;

    /**
     * Sets the AbstractCardFactory of this object.
     * @param factory An AbstractCardFactory object.
     */
    public void setFactory(AbstractCardFactory<T> factory){
        this.factory = factory;
    }

    /**
     * Returns the AbstractCardFactory of this object.
     * @return An AbstractCardFactory object.
     */
    public AbstractCardFactory<T> getFactory(){
        return factory;
    }

    /**
     * Returns a Collection with items of type T.
     * @return A Collection<T>
     */
    public abstract Collection<T> getDeck();
}

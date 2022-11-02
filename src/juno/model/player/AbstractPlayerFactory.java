package juno.model.player;

import java.util.List;

/**
 * @author steghy
 * @param <T> The items type
 */
public abstract class AbstractPlayerFactory<T> implements InterfacePlayerFactory<T> {

    /* The AbstractNameFactory component */
    private AbstractNameFactory nameFactory;

    /**
     * Sets the AbstractNameFactory object of this instance.
     * @param factory An AbstractNameFactory.
     */
    public void setNameFactory(AbstractNameFactory nameFactory) {
        this.nameFactory = nameFactory;
    }

    /**
     * Returns the AbstractNameFactory object of this
     * instance.
     * @return An AbstractNameFactory object
     */
    public AbstractNameFactory getNameFactory() {
        return nameFactory;
    }
}

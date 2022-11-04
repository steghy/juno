package juno.model.player.factory;

/**
 * @author steghy
 * @param <T> The items type
 */
public abstract class AbstractPlayersFactory<T> implements  InterfacePlayersFactory<T>, InterfacePlayersGenerator<T> {

    /* The AbstractNameFactory component */
    private AbstractNameFactory nameFactory;

    /**
     * Sets the AbstractNameFactory object of this instance.
     * @param nameFactory An AbstractNameFactory.
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

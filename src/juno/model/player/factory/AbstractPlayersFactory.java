package juno.model.player.factory;

public abstract class AbstractPlayersFactory<T> implements  InterfacePlayersFactory<T>, AbstractPlayersGenerator<T> {

    private AbstractNameFactory nameFactory;

    public void setNameFactory(AbstractNameFactory nameFactory) {
        this.nameFactory = nameFactory;
    }

    public AbstractNameFactory getNameFactory() {
        return nameFactory;
    }
}

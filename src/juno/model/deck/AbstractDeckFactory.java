package juno.model.deck;

public abstract class AbstractDeckFactory<T> implements InterfaceDeckFactory<T> {

    private AbstractCardFactory<T> factory;

    public void setCardFactory(AbstractCardFactory<T> factory){
        this.factory = factory;
    }

    public AbstractCardFactory<T> getCardFactory(){
        return factory;
    }

}

package juno.model.deck;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractDeckFactory<T>
        implements InterfaceDeckFactory<T> {

    private InterfaceCardFactory<T> factory;

    public void setCardFactory(@NotNull InterfaceCardFactory<T> factory){
        this.factory = factory;
    }

    public InterfaceCardFactory<T> getCardFactory(){
        return factory;
    }

}

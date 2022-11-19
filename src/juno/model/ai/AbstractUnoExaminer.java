package juno.model.ai;

import juno.model.card.AbstractCompatibleItemsProvider;

public abstract class AbstractUnoExaminer<T> implements InterfaceUnoExaminer<T> {

    private AbstractCompatibleItemsProvider<T> compatibleItemsProvider;

    public void setCompatibleItemsProvider(AbstractCompatibleItemsProvider<T> compatibleItemsProvider) {
        this.compatibleItemsProvider = compatibleItemsProvider;
    }

    public AbstractCompatibleItemsProvider<T> getCompatibleItemsProvider() {
        return compatibleItemsProvider;
    }
}

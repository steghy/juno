package juno.model.ai;

import juno.model.card.AbstractCompatibleItemsProvider;

public abstract class AbstractUnoAi<T> implements InterfaceUnoAi<T> {

    private AbstractCompatibleItemsProvider<T> compatibleItemsProvider;
    private InterfaceUnoExaminer<T> unoExaminer;

    public void setCompatibleItemsProvider(AbstractCompatibleItemsProvider<T> compatibleItemsProvider) {
        this.compatibleItemsProvider = compatibleItemsProvider;
    }

    public void setUnoExaminer(InterfaceUnoExaminer<T> unoExaminer) {
        this.unoExaminer = unoExaminer;
    }

    public AbstractCompatibleItemsProvider<T> getCompatibleItemsProvider() {
        return compatibleItemsProvider;
    }

    public InterfaceUnoExaminer<T> getUnoExaminer() {
        return unoExaminer;
    }
}

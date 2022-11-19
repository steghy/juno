package juno.model.subjects.ai;

import juno.model.card.AbstractCompatibleItemsProvider;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractUnoExaminer<T> implements InterfaceUnoExaminer<T> {

    private AbstractCompatibleItemsProvider<T> compatibleItemsProvider;

    public void setCompatibleItemsProvider(@NotNull AbstractCompatibleItemsProvider<T> compatibleItemsProvider) {
        this.compatibleItemsProvider = compatibleItemsProvider;
    }

    public AbstractCompatibleItemsProvider<T> getCompatibleItemsProvider() {
        return compatibleItemsProvider;
    }
}

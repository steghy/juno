package juno.model.subjects.ai;

import juno.model.card.AbstractCompatibleItemsProvider;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractUnoAI<T>
        implements InterfaceUnoAi<T> {

    private AbstractCompatibleItemsProvider<T> compatibleItemsProvider;
    private InterfaceUnoExaminer<T> unoExaminer;

    public void setCompatibleItemsProvider(@NotNull AbstractCompatibleItemsProvider<T> compatibleItemsProvider) {
        this.compatibleItemsProvider = compatibleItemsProvider;
    }

    public void setUnoExaminer(@NotNull InterfaceUnoExaminer<T> unoExaminer) {
        this.unoExaminer = unoExaminer;
    }

    public AbstractCompatibleItemsProvider<T> getCompatibleItemsProvider() {
        return compatibleItemsProvider;
    }

    public InterfaceUnoExaminer<T> getUnoExaminer() {
        return unoExaminer;
    }
}

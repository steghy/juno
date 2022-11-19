package juno.model.ai;

import java.util.List;

public class UnoAi<T> extends AbstractUnoAi<T> {

    private List<T> items;

    public UnoAi() {
    }

    @Override
    public T makeAChoice() {
        if(getCompatibleItemsProvider() != null) {
            if(getUnoExaminer() != null) {
                return null;
            } else {
                throw new IllegalArgumentException("UnoExaminer is null");
            }
        } else {
            throw new IllegalArgumentException("CompatibleItemsProvider is null");
        }
    }

    @Override
    public String subjectName() {
        return null;
    }

    @Override
    public void addItem(T item) {

    }

    @Override
    public void removeItem(T item) {

    }
}

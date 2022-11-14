package juno.model.subjects.factory;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractSubjectsFactory<T> implements InterfaceSubjectsFactory<T>, AbstractSubjectsGenerator<T> {

    private AbstractNameFactory nameFactory;

    public void setNameFactory(@NotNull AbstractNameFactory nameFactory) {
        this.nameFactory = nameFactory;
    }

    public AbstractNameFactory getNameFactory() {
        return nameFactory;
    }
}

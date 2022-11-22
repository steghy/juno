package juno.model.subjects.factory;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractSubjectsFactory<T>
        implements InterfaceSubjectsFactory<T>, InterfaceSubjectsGenerator<T> {

    private InterfaceNameFactory nameFactory;

    public void setNameFactory(@NotNull InterfaceNameFactory nameFactory) {
        this.nameFactory = nameFactory;
    }

    public InterfaceNameFactory getNameFactory() {
        return nameFactory;
    }
}

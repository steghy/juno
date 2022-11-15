package juno.model.data;

public interface Exportable<T, E> {

    AbstractDataProvider<T, E> export();
}

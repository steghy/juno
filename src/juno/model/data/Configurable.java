package juno.model.data;

public interface Configurable<T, E> {

    void configure(AbstractDataProvider<T, E> data) throws DataCorruptedException;
}

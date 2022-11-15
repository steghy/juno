package juno.model.data;

public interface AbstractDataConfigurable<T, E> {

    void put(T key, E value);
}

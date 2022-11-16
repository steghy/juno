package juno.model.data;

import java.util.Map;

public interface Configurable<T, E> {

    void configure(Map<T, E> map) throws DataCorruptedException;
}

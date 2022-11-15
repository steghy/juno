package juno.model.data;


import java.util.Map;

public interface AbstractData<T, E> {

    Map<T, E> getDataMap();
}

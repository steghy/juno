package juno.model.data;

import java.util.Map;

public interface AbstractDataProvider<T, E> {

    Map<T, E> getDataMap();
}

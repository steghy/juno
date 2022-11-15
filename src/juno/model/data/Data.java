package juno.model.data;

import java.util.Map;

public class Data<T, E> implements AbstractDataProvider<T, E>, AbstractDataConfigurable<T, E> {

    private Map<T, E> dataMap;

    @Override
    public Map<T, E> getDataMap() {
        return dataMap;
    }

    @Override
    public void put(T key, E value) {
        dataMap.put(key, value);
    }
}

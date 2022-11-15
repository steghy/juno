package juno.model.data;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Data<T, E> implements AbstractData<T, E> {

    private final Map<T, E> dataMap;

    public Data() {
        dataMap = new HashMap<>();
    }

    public void addData(@NotNull T key,@NotNull E value) {
        dataMap.put(key, value);
    }

    @Override
    public Map<T, E> getDataMap() {
        return dataMap;
    }
}

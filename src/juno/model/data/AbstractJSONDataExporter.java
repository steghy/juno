package juno.model.data;

import java.util.Map;

public interface AbstractJSONDataExporter<T, E> {

    void exportJSONData(String path, Map<T, E> map);
}

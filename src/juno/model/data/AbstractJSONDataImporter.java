package juno.model.data;

import java.util.Map;

public interface AbstractJSONDataImporter<T, E> {

    Map<T, E> importJSONData(String path);
}

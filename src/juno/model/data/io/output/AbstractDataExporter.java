package juno.model.data.io.output;

import java.io.IOException;
import java.util.Map;

public interface AbstractDataExporter {

    void exportData(String path, Map<String, Object> dataMap) throws IOException;
}

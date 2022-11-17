package juno.model.data.io;

import java.io.IOException;
import java.util.Map;

public interface AbstractDataImporter {

    Map<String, Object> importData(String path) throws IOException;
}



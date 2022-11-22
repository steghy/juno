package juno.model.data.io.input;

import java.io.IOException;
import java.util.Map;

@FunctionalInterface
public interface InterfaceDataImporter {

    Map<String, Object> importData(String path) throws IOException;
}



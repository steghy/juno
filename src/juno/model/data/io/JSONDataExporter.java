package juno.model.data.io;

import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class JSONDataExporter implements AbstractDataExporter {

    @Override
    public void exportData(String path, Map<String, Object> dataMap) throws IOException {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(dataMap);
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(jsonArray.toString());
        fileWriter.close();
    }
}

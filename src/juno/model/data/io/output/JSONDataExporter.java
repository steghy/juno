package juno.model.data.io.output;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class JSONDataExporter 
        implements AbstractDataExporter {

    private static JSONDataExporter instance;

    private JSONDataExporter() {}

    public static JSONDataExporter getInstance() {
        if(instance == null) {
            instance = new JSONDataExporter();
        } return instance;
    }

    @Override
    public void exportData(@NotNull String path, 
                           @NotNull Map<String, Object> map) throws IOException {
        JSONObject jsonObject = new JSONObject(map);
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(jsonObject.toString());
        fileWriter.close();
    }
}

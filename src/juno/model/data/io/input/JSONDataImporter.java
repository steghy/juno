package juno.model.data.io.input;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JSONDataImporter implements InterfaceDataImporter {

    private static JSONDataImporter instance;

    private JSONDataImporter() {}

    public static JSONDataImporter getInstance() {
        if(instance == null) {
            instance = new JSONDataImporter();
        } return instance;
    }

    @Override
    public Map<String, Object> importData(String path) throws IOException {
        String source = new String(Files.readAllBytes(Paths.get(path)));
        System.out.println(source);
        JSONObject jsonObject = new JSONObject(source);
        return jsonObject.toMap();
    }
}

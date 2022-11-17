package juno.model.data.io;

import java.io.IOException;
import java.util.Map;

public class CONFIGDataExporter implements AbstractDataImporter{

    private static CONFIGDataExporter instance;

    private CONFIGDataExporter() {}

    public static CONFIGDataExporter getInstance() {
        if(instance == null) {
            instance = new CONFIGDataExporter();
        } return instance;
    }

    @Override
    public Map<String, Object> importData(String path) throws IOException {
        return null;
    }
}

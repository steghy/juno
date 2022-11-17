package juno.model.data.io;

import java.io.IOException;
import java.util.Map;

public class CONFIGDataImporter implements AbstractDataImporter{

    private static CONFIGDataImporter instance;

    private CONFIGDataImporter() {}

    public static CONFIGDataImporter getInstance() {
        if(instance == null) {
            instance = new CONFIGDataImporter();
        } return instance;
    }

    @Override
    public Map<String, Object> importData(String path) throws IOException {
        return null;
    }
}

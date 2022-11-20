package juno.model.data.io.output;

import juno.model.data.io.input.InterfaceDataImporter;

import java.io.IOException;
import java.util.Map;

public class CONFIGDataExporter implements InterfaceDataImporter {

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

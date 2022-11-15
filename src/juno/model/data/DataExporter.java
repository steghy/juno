package juno.model.data;

import juno.model.util.Os;

import java.io.File;
import java.io.PrintWriter;

public class DataExporter implements AbstractDataExporter{

    private PrintWriter printWriter;

    private static DataExporter instance;

    private DataExporter() {}

    public static DataExporter getInstance() {
        if(instance == null) {
            instance = new DataExporter();
        } return instance;
    }

    @Override
    public void exportData(AbstractData<?, ?> data, String path) {
        // che succede se viene passato un percorso come il seguente ?
        // /test-file.config
        // La parent dir in questo caso non esiste ? Bisogna verificare.
        File file = new File(path);
        if(file.getParentFile().exists()) {
            if(!file.exists()) {

            } else {
                throw new IllegalArgumentException("File already exists: " + path);
            }
        } else {
            throw new IllegalArgumentException("Parent file not exists: " + path);
        }
    }
}

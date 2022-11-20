package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DataCompatibilityChecker implements AbstractDataCompatibilityChecker {

    private final Map<Configurable, File> incompatibleFiles;
    private InterfaceDataImporter dataImporter;

    private static DataCompatibilityChecker instance;

    private DataCompatibilityChecker() {
        incompatibleFiles = new HashMap<>();
    }

    public static DataCompatibilityChecker getInstance() {
        if(instance == null) {
            instance = new DataCompatibilityChecker();
        } return instance;
    }

    @Override
    public boolean checkCompatibilityOf(@NotNull Configurable configurable, File file) {
        try {
            configurable.configure(dataImporter.importData(file.getAbsolutePath()));
            return true;
        } catch(Exception e) {
            incompatibleFiles.put(configurable, file);
            return false;
        }
    }

    public void setDataImporter(InterfaceDataImporter dataImporter) {
        this.dataImporter = dataImporter;
    }

    public InterfaceDataImporter getDataImporter() {
        return dataImporter;
    }

    public Map<Configurable, File> getIncompatibleFiles() {
        return incompatibleFiles;
    }
}

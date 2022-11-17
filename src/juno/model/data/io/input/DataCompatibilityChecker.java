package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class DataCompatibilityChecker implements AbstractDataCompatibilityChecker {

    private AbstractDataImporter dataImporter;

    private static DataCompatibilityChecker instance;

    private DataCompatibilityChecker() {}

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
            e.printStackTrace();
            return false;
        }
    }

    public void setDataImporter(AbstractDataImporter dataImporter) {
        this.dataImporter = dataImporter;
    }

    public AbstractDataImporter getDataImporter() {
        return dataImporter;
    }
}

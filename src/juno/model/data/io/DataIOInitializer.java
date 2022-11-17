package juno.model.data.io;

public class DataIOInitializer {

    private DataIOInitializer() {}

    public static void initialize() {
        ConfigurationFilesProvider configurationFilesProvider = ConfigurationFilesProvider.getInstance();
        DataCompatibilityChecker dataCompatibilityChecker = DataCompatibilityChecker.getInstance();
        AbstractDataImporter dataImporter = JSONDataImporter.getInstance();

        dataCompatibilityChecker.setDataImporter(dataImporter);
        configurationFilesProvider.setDataCompatibilityChecker(dataCompatibilityChecker);
    }
}

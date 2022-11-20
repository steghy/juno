package juno.model.data.io.input;

public class InputDataInitializer {

    private InputDataInitializer() {}

    public static void initialize() {
        ConfigurationFilesProvider configurationFilesProvider = ConfigurationFilesProvider.getInstance();
        DataCompatibilityChecker dataCompatibilityChecker = DataCompatibilityChecker.getInstance();
        InterfaceDataImporter dataImporter = JSONDataImporter.getInstance();

        dataCompatibilityChecker.setDataImporter(dataImporter);
        configurationFilesProvider.setDataCompatibilityChecker(dataCompatibilityChecker);
    }
}

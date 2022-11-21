package juno.model.data.io.input;

public class InputDataInitializer {

    private InputDataInitializer() {}

    public static void initialize() {
        // CCOMPATIBILITY CHECKER
        JSONDataImporter jsonDataImporter = JSONDataImporter.getInstance();
        PropertyCopier propertyCopier = PropertyCopier.getInstance();
        CCompatibilityChecker cCompatibilityChecker = CCompatibilityChecker.getInstance();
        cCompatibilityChecker.setDataImporter(jsonDataImporter);
        cCompatibilityChecker.setPropertyCopier(propertyCopier);

        // RCOMPATIBILITY CHECKER
        RCompatibilityChecker rCompatibilityChecker = RCompatibilityChecker.getInstance();
        RConfigurator rConfigurator = RConfigurator.getInstance();
        rCompatibilityChecker.setDataImporter(jsonDataImporter);
        rCompatibilityChecker.setPropertyCopier(propertyCopier);
        rCompatibilityChecker.setRConfigure(rConfigurator);

        // CCONFIGURATION FILES PROVIDER
        CConfigurationFilesProvider cConfigurationFilesProvider = CConfigurationFilesProvider.getInstance();
        cConfigurationFilesProvider.setCCompatibilityChecker(cCompatibilityChecker);

        // RCONFIGURATION FILES PROVIDER
        RConfigurationFilesProvider rConfigurationFilesProvider = RConfigurationFilesProvider.getInstance();
        rConfigurationFilesProvider.setRCompatibilityChecker(rCompatibilityChecker);

        // CONFIGURATION FILES PROVIDER
        ConfigurationFilesProvider configurationFilesProvider = ConfigurationFilesProvider.getInstance();
        configurationFilesProvider.setCConfigurationFilesProvider(cConfigurationFilesProvider);
        configurationFilesProvider.setRConfigurationFilesProvider(rConfigurationFilesProvider);
    }
}
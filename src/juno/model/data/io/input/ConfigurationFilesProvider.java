package juno.model.data.io.input;

import java.io.File;
import java.util.List;

public class ConfigurationFilesProvider extends AbstractConfigurationFilesProvider implements InterfaceConfigurationFilesProvider {

    @Override
    public List<File> getConfigurationFiles(Configurable configurable, String path) {
        return getCConfigurationFilesProvider().getConfigurationFiles(configurable, path);
    }

    @Override
    public List<File> getConfigurationFiles(Object object, String path) {
        return getRConfigurationFilesProvider().getConfigurationFiles(object, path);
    }

    @Override
    public List<File> getConfigurationFiles(Class<?> clazz, String path) {
        return getRConfigurationFilesProvider().getConfigurationFiles(clazz, path);
    }
}

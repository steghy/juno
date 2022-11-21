package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ConfigurationFilesProvider
        extends AbstractConfigurationFilesProvider
        implements InterfaceConfigurationFilesProvider {

    private static ConfigurationFilesProvider instance;

    private ConfigurationFilesProvider() {}

    public static ConfigurationFilesProvider getInstance() {
        if(instance == null) instance = new ConfigurationFilesProvider();
        return instance;
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Configurable configurable,
                                            @NotNull String path) throws FileNotFoundException {
        return getCConfigurationFilesProvider().getConfigurationFiles(configurable, path);
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Object object,
                                            @NotNull String path) throws FileNotFoundException {
        return getRConfigurationFilesProvider().getConfigurationFiles(object, path);
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Class<?> clazz,
                                            @NotNull String path) throws FileNotFoundException {
        return getRConfigurationFilesProvider().getConfigurationFiles(clazz, path);
    }
}

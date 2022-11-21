package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CConfigurationFilesProvider
        extends AbstractCConfigurationFilesProvider
        implements InterfaceCConfigurationFilesProvider {

    private final List<File> configurationFiles;

    private static CConfigurationFilesProvider instance;

    private CConfigurationFilesProvider() {
        configurationFiles = new ArrayList<>();
    }

    public static CConfigurationFilesProvider getInstance() {
        if (instance == null) instance = new CConfigurationFilesProvider();
        return instance;
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Configurable configurable,
                                            @NotNull String path) throws FileNotFoundException{
        configurationFiles.clear();
        setConfigurationFilesRecursive(configurable, path);
        return configurationFiles;
    }

    public void setConfigurationFilesRecursive(@NotNull Configurable configurable,
                                               @NotNull String path) throws FileNotFoundException {
        File inputFile = new File(path);
        if (!inputFile.exists()) throw new FileNotFoundException(path);
        if (inputFile.isFile() &&
                getCCompatibilityChecker().checkCompatibilityOf(configurable, path))
                configurationFiles.add(inputFile);
        else
            if (inputFile.listFiles() != null)
                for(File file : Objects.requireNonNull(inputFile.listFiles())) {
                    if(file.isFile() &&
                            getCCompatibilityChecker()
                                    .checkCompatibilityOf(configurable, file.getAbsolutePath()))
                        configurationFiles.add(file);
                    else
                        setConfigurationFilesRecursive(configurable, file.getAbsolutePath());
                }
    }
}
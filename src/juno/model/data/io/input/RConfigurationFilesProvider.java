package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RConfigurationFilesProvider
        extends AbstractRConfigurationFilesProvider
        implements InterfaceRConfigurationFilesProvider {

    private final List<File> configurationFiles;
    private static RConfigurationFilesProvider instance;

    private RConfigurationFilesProvider() {
        configurationFiles = new ArrayList<>();
    }

    public static RConfigurationFilesProvider getInstance() {
        if(instance == null) instance = new RConfigurationFilesProvider();
        return instance;
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Object object,
                                            @NotNull String path) throws FileNotFoundException {
        configurationFiles.clear();
        setConfigurationFilesRecursive(object, path);
        return new ArrayList<>(configurationFiles);
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Class<?> clazz,
                                            @NotNull String path) throws FileNotFoundException {
       configurationFiles.clear();
       setConfigurationFilesRecursive(clazz, path);
       return new ArrayList<>(configurationFiles);
    }

    private void setConfigurationFilesRecursive(@NotNull Object object,
                                                @NotNull String path) throws FileNotFoundException {
        File inputFile = new File(path);
        if (!inputFile.exists()) throw new FileNotFoundException(path);
        if (inputFile.isFile() &&
                getRCompatibilityChecker().checkCompatibilityOf(object, path))
            configurationFiles.add(inputFile);
        else
        if (inputFile.listFiles() != null)
            for(File file : Objects.requireNonNull(inputFile.listFiles())) {
                if(file.isFile() &&
                        getRCompatibilityChecker()
                                .checkCompatibilityOf(object, file.getAbsolutePath()))
                    configurationFiles.add(file);
                else
                    setConfigurationFilesRecursive(object, file.getAbsolutePath());
            }
    }

    private void setConfigurationFilesRecursive(@NotNull Class<?> clazz,
                                                @NotNull String path) throws FileNotFoundException {
        File inputFile = new File(path);
        if (!inputFile.exists()) throw new FileNotFoundException(path);
        if (inputFile.isFile() &&
                getRCompatibilityChecker().checkCompatibilityOf(clazz, path))
            configurationFiles.add(inputFile);
        else
        if (inputFile.listFiles() != null)
            for(File file : Objects.requireNonNull(inputFile.listFiles())) {
                if(file.isFile() &&
                        getRCompatibilityChecker()
                                .checkCompatibilityOf(clazz, file.getAbsolutePath()))
                    configurationFiles.add(file);
                else
                    setConfigurationFilesRecursive(clazz, file.getAbsolutePath());
            }
    }
}
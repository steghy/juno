package juno.model.data.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigurationFilesProvider implements AbstractConfigurationFilesProvider {

    private AbstractDataCompatibilityChecker dataCompatibilityChecker;

    private static ConfigurationFilesProvider instance;

    private ConfigurationFilesProvider() {}

    public static ConfigurationFilesProvider getInstance() {
        if(instance == null) {
            instance = new ConfigurationFilesProvider();
        } return instance;
    }

    @Override
    public List<File> getConfigurationFiles(String path, Configurable configurable) {
        File file = new File(path);
        if(file.exists()) {
            if(file.isDirectory()) {
                File[] files = file.listFiles();
                if(files != null) {
                    return Arrays.stream(files)
                            .filter(obj -> dataCompatibilityChecker
                                    .checkCompatibilityOf(configurable, obj))
                            .toList();
                } else {
                    return new ArrayList<>();
                }
            } else {
                if(dataCompatibilityChecker.checkCompatibilityOf(configurable, file)) {
                    return List.of(file);
                } else {
                    return new ArrayList<>();
                }
            }
        } else {
            throw new IllegalArgumentException("Not exists: " + file.getAbsolutePath());
        }
    }

    public void setDataCompatibilityChecker(AbstractDataCompatibilityChecker dataCompatibilityChecker) {
        this.dataCompatibilityChecker = dataCompatibilityChecker;
    }

    public AbstractDataCompatibilityChecker getDataCompatibilityChecker() {
        return dataCompatibilityChecker;
    }

}
package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CConfigurationFilesProvider extends AbstractCConfigurationFilesProvider implements InterfaceCConfigurationFilesProvider {

    private static CConfigurationFilesProvider instance;

    private CConfigurationFilesProvider() {}

    public static CConfigurationFilesProvider getInstance() {
        if(instance == null) {
            instance = new CConfigurationFilesProvider();
        } return instance;
    }

    @Override
    public List<File> getConfigurationFiles(@NotNull Configurable configurable, @NotNull String path) {
        File file = new File(path);
        if(file.exists()) {
            if(file.isDirectory()) {
                File[] files = file.listFiles();
                if(files != null) {
                    return Arrays.stream(files)
                            .filter(obj -> getCCompatibilityChecker()
                                    .checkCompatibilityOf(configurable, path))
                            .toList();
                } else {
                    return new ArrayList<>();
                }
            } else {
                if(getCCompatibilityChecker().checkCompatibilityOf(configurable, path)) {
                    return List.of(file);
                } else {
                    return new ArrayList<>();
                }
            }
        } else {
            throw new IllegalArgumentException("Not exists: " + file.getAbsolutePath());
        }
    }
}
package juno.model.data.io.input;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RConfigurationFilesProvider extends AbstractRConfigurationFilesProvider implements InterfaceRConfigurationFilesProvider {

    @Override
    public List<File> getConfigurationFiles(Object object, String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    return Arrays.stream(files)
                            .filter(obj -> getRCompatibilityChecker()
                                    .checkCompatibilityOf(object, path))
                            .toList();
                } else {
                    return new ArrayList<>();
                }
            } else {
                if (getRCompatibilityChecker().checkCompatibilityOf(object, path)) {
                    return List.of(file);
                } else {
                    return new ArrayList<>();
                }
            }
        } else {
            throw new IllegalArgumentException("Not exists: " + file.getAbsolutePath());
        }
    }

    @Override
    public List<File> getConfigurationFiles(Class<?> clazz, String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    return Arrays.stream(files)
                            .filter(obj -> getRCompatibilityChecker()
                                    .checkCompatibilityOf(clazz, path))
                            .toList();
                } else {
                    return new ArrayList<>();
                }
            } else {
                if (getRCompatibilityChecker().checkCompatibilityOf(clazz, path)) {
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

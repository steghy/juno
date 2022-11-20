package juno.model.data.io.input;

import java.io.File;
import java.util.List;

public interface InterfaceConfigurationFilesProvider {

    List<File> getConfigurationFiles(Configurable configurable, String path);

    List<File> getConfigurationFiles(Object object, String path);

    List<File> getConfigurationFiles(Class<?> clazz, String path);
}

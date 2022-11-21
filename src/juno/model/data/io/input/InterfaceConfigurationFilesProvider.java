package juno.model.data.io.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface InterfaceConfigurationFilesProvider {

    List<File> getConfigurationFiles(Configurable configurable, String path) throws FileNotFoundException;

    List<File> getConfigurationFiles(Object object, String path) throws FileNotFoundException;

    List<File> getConfigurationFiles(Class<?> clazz, String path) throws FileNotFoundException;
}

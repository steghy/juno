package juno.model.data.io.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@FunctionalInterface
public interface InterfaceCConfigurationFilesProvider {

    List<File> getConfigurationFiles(Configurable configurable, String path) throws FileNotFoundException;
}

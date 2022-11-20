package juno.model.data.io.input;

import java.io.File;
import java.util.List;

public interface InterfaceCConfigurationFilesProvider {

    List<File> getConfigurationFiles(Configurable configurable, String path);
}

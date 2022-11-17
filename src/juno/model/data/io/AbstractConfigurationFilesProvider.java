package juno.model.data.io;

import java.io.File;
import java.util.List;

public interface AbstractConfigurationFilesProvider {

    List<File> getConfigurationFiles(String path, Configurable configurable);
}

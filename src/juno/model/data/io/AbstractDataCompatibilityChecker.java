package juno.model.data.io;

import java.io.File;

public interface AbstractDataCompatibilityChecker {

    boolean checkCompatibilityOf(Configurable configurable, File file);
}

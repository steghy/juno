package juno.model.data.io.input;

import java.io.File;

public interface AbstractDataCompatibilityChecker {

    boolean checkCompatibilityOf(Configurable configurable, File file);
}

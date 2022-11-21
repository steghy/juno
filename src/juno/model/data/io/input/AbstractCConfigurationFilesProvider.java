package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

public class AbstractCConfigurationFilesProvider {

    InterfaceCCompatibilityChecker cCompatibilityChecker;

    public void setCCompatibilityChecker(@NotNull InterfaceCCompatibilityChecker cCompatibilityChecker) {
        this.cCompatibilityChecker = cCompatibilityChecker;
    }

    public InterfaceCCompatibilityChecker getCCompatibilityChecker() {
        return cCompatibilityChecker;
    }
}

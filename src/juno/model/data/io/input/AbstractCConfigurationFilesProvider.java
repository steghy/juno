package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

public class AbstractCConfigurationFilesProvider {

    InterfaceStringCCompatibilityChecker cCompatibilityChecker;

    public void setCCompatibilityChecker(@NotNull InterfaceStringCCompatibilityChecker cCompatibilityChecker) {
        this.cCompatibilityChecker = cCompatibilityChecker;
    }

    public InterfaceStringCCompatibilityChecker getCCompatibilityChecker() {
        return cCompatibilityChecker;
    }
}

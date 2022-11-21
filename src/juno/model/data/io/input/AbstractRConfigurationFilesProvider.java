package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

public class AbstractRConfigurationFilesProvider {

    private InterfaceRCompatibilityChecker rCompatibilityChecker;

    public void setRCompatibilityChecker(@NotNull InterfaceRCompatibilityChecker rCompatibilityChecker) {
        this.rCompatibilityChecker = rCompatibilityChecker;
    }

    public InterfaceRCompatibilityChecker getRCompatibilityChecker() {
        return rCompatibilityChecker;
    }
}

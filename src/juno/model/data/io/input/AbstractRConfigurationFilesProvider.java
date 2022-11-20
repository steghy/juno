package juno.model.data.io.input;

public class AbstractRConfigurationFilesProvider {

    private InterfaceRCompatibilityChecker rCompatibilityChecker;

    public void setRCompatibilityChecker(InterfaceRCompatibilityChecker rCompatibilityChecker) {
        this.rCompatibilityChecker = rCompatibilityChecker;
    }

    public InterfaceRCompatibilityChecker getRCompatibilityChecker() {
        return rCompatibilityChecker;
    }
}

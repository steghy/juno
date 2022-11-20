package juno.model.data.io.input;

public class AbstractCConfigurationFilesProvider {

    InterfaceCCompatibilityChecker cCompatibilityChecker;

    private void setCCompatibilityChecker(InterfaceCCompatibilityChecker cCompatibilityChecker) {
        this.cCompatibilityChecker = cCompatibilityChecker;
    }

    public InterfaceCCompatibilityChecker getCCompatibilityChecker() {
        return cCompatibilityChecker;
    }
}

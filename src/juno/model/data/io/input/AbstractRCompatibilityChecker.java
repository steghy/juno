package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

public class AbstractRCompatibilityChecker extends AbstractCompatibilityChecker {

    private InterfaceRConfigurator rConfigurator;

    public void setRConfigure(@NotNull InterfaceRConfigurator rConfigurator) {
        this.rConfigurator = rConfigurator;
    }

    public InterfaceRConfigurator getRConfigurator() {
        return rConfigurator;
    }
}

package juno.model.data.io.input;

public class AbstractRCompatibilityChecker extends AbstractCompatibilityChecker {

    private InterfaceRConfigurator rConfigurator;

    public void setRConfigure(InterfaceRConfigurator rConfigurator) {
        this.rConfigurator = rConfigurator;
    }

    public InterfaceRConfigurator getRConfigurator() {
        return rConfigurator;
    }
}

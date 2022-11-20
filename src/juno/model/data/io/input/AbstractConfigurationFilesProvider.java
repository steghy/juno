package juno.model.data.io.input;

public abstract class AbstractConfigurationFilesProvider {

    private InterfaceRConfigurationFilesProvider rConfigurationFilesProvider;

    private InterfaceCConfigurationFilesProvider cConfigurationFilesProvider;

    public void setRConfigurationFilesProvider(InterfaceRConfigurationFilesProvider rConfigurationFilesProvider) {
        this.rConfigurationFilesProvider = rConfigurationFilesProvider;
    }

    public void setCConfigurationFilesProvider(InterfaceCConfigurationFilesProvider cConfigurationFilesProvider) {
        this.cConfigurationFilesProvider = cConfigurationFilesProvider;
    }

    public InterfaceRConfigurationFilesProvider getRConfigurationFilesProvider() {
        return rConfigurationFilesProvider;
    }

    public InterfaceCConfigurationFilesProvider getCConfigurationFilesProvider() {
        return cConfigurationFilesProvider;
    }
}
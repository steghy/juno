package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractConfigurationFilesProvider {

    private InterfaceRConfigurationFilesProvider rConfigurationFilesProvider;

    private InterfaceCConfigurationFilesProvider cConfigurationFilesProvider;

    public void setRConfigurationFilesProvider(@NotNull InterfaceRConfigurationFilesProvider rConfigurationFilesProvider) {
        this.rConfigurationFilesProvider = rConfigurationFilesProvider;
    }

    public void setCConfigurationFilesProvider(@NotNull InterfaceCConfigurationFilesProvider cConfigurationFilesProvider) {
        this.cConfigurationFilesProvider = cConfigurationFilesProvider;
    }

    public InterfaceRConfigurationFilesProvider getRConfigurationFilesProvider() {
        return rConfigurationFilesProvider;
    }

    public InterfaceCConfigurationFilesProvider getCConfigurationFilesProvider() {
        return cConfigurationFilesProvider;
    }
}
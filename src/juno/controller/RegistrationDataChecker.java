package juno.controller;

import juno.model.data.io.input.Configurable;
import juno.model.data.io.input.InterfaceMapCCompatibilityChecker;
import juno.model.data.io.input.InterfaceStringCCompatibilityChecker;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class RegistrationDataChecker
        implements ActionListener, InterfaceRegistrationDataChecker {

    private InterfaceRegistrationDataProvider provider;

    private InterfaceMapCCompatibilityChecker compatibilityChecker;

    private Configurable configurable;

    private static RegistrationDataChecker instance;

    private RegistrationDataChecker() {}

    public static RegistrationDataChecker getInstance() {
        if(instance == null) instance = new RegistrationDataChecker();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(provider == null) {
            throw new IllegalArgumentException("RegistrationDataProvider is null");
        }

        Map<String, Object> data = provider.provideRegistrationData();
        if(!data.isEmpty()) {
            
        }
    }

    @Override
    public Map<String, String> getResponse() {

    }

    public void setProvider(@NotNull InterfaceRegistrationDataProvider provider) {
        this.provider = provider;
    }

    public void setCompatibilityChecker(@NotNull InterfaceMapCCompatibilityChecker compatibilityChecker) {
        this.compatibilityChecker = compatibilityChecker;
    }

    public void setConfigurable(@NotNull Configurable configurable) {
        this.configurable = configurable;
    }
}
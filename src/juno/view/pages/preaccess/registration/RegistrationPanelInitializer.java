package juno.view.pages.preaccess.registration;

import juno.view.pages.preaccess.registration.menu.MenuPanelConfigurator;
import juno.view.pages.preaccess.registration.title.TitlePanelConfigurator;

public class RegistrationPanelInitializer {

    private RegistrationPanelInitializer() {}

    public static void initialize() {
        // SUB-COMPONENTS
        TitlePanelConfigurator.configure();
        MenuPanelConfigurator.configure();

        // MAIN-COMPONENT
        RegistrationPanelConfigurator.configure();
    }
}
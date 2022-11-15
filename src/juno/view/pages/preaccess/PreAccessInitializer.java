package juno.view.pages.preaccess;

import juno.view.pages.preaccess.access.AccessPanelInitializer;
import juno.view.pages.preaccess.card.PreAccessCardPanelConfigurator;
import juno.view.pages.preaccess.login.LogInPanelInitializer;
import juno.view.pages.preaccess.registration.RegistrationPanelInitializer;
import juno.view.pages.preaccess.welcome.WelcomePanelInitialize;

public class PreAccessInitializer {

    private PreAccessInitializer() {}

    public static void initialize() {
        // SUB COMPONENTS CONFIGURATION
        WelcomePanelInitialize.initialize();
        AccessPanelInitializer.initialize();
        RegistrationPanelInitializer.initialize();
        LogInPanelInitializer.initialize();

        // CARD PANEL COMPONENT CONFIGURATION
        PreAccessCardPanelConfigurator.configure();
    }
}

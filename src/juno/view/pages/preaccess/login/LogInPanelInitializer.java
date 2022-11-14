package juno.view.pages.preaccess.login;

import juno.view.pages.preaccess.login.menu.MenuPanelConfigurator;
import juno.view.pages.preaccess.login.title.TitlePanelConfigurator;

public class LogInPanelInitializer {

    private LogInPanelInitializer() {}

    public static void initialize() {
        // SUB-COMPONENTS
        TitlePanelConfigurator.configure();
        MenuPanelConfigurator.configure();

        // MAIN COMPONENT
        LogInPanelConfiguration.configure();
    }
}
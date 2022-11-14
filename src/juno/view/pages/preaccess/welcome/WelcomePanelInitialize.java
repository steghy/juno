package juno.view.pages.preaccess.welcome;

import juno.view.pages.preaccess.welcome.title.TitlePanelConfigurator;
import juno.view.pages.preaccess.welcome.menu.MenuPanelConfigurator;

public class WelcomePanelInitialize {

    private WelcomePanelInitialize() {}

    public static void initialize() {
        // SUB-COMPONENTS
        TitlePanelConfigurator.configure();;
        MenuPanelConfigurator.configure();

        // MAIN COMPONENT
        WelcomePanelConfigurator.configure();
    }
}
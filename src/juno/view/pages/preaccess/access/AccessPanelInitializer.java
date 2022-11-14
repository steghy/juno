package juno.view.pages.preaccess.access;

import juno.view.pages.preaccess.access.menu.MenuPanelConfigurator;
import juno.view.pages.preaccess.access.title.TitlePanelConfigurator;

public class AccessPanelInitializer {

    private AccessPanelInitializer() {}

    public static void initialize() {
        // SUB-COMPONENTS
        TitlePanelConfigurator.configure();
        MenuPanelConfigurator.configure();

        // MAIN COMPONENT
        AccessPanelConfigurator.configure();
    }
}
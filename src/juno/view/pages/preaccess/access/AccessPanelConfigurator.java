package juno.view.pages.preaccess.access;

import juno.view.pages.preaccess.access.menu.MenuPanel;
import juno.view.pages.preaccess.access.title.TitlePanel;

public class AccessPanelConfigurator {

    private AccessPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        AccessPanel welcomePanel = AccessPanel.getInstance();

        // SUB-COMPONENTS
        TitlePanel titlePanel = TitlePanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();

        // ADDING COMPONENTS
        welcomePanel.setTitlePanel(titlePanel);
        welcomePanel.setMenuPanel(menuPanel);

        // INITIALIZATION
        welcomePanel.init();
    }
}
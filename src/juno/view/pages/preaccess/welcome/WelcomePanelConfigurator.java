package juno.view.pages.preaccess.welcome;

import juno.view.pages.preaccess.welcome.menu.MenuPanel;
import juno.view.pages.preaccess.welcome.title.TitlePanel;

public class WelcomePanelConfigurator {

    private WelcomePanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        WelcomePanel welcomePanel = WelcomePanel.getInstance();

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
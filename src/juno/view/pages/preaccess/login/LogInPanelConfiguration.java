package juno.view.pages.preaccess.login;

import juno.view.pages.preaccess.login.menu.MenuPanel;
import juno.view.pages.preaccess.login.title.TitlePanel;

public class LogInPanelConfiguration {

    private LogInPanelConfiguration() {}

    public static void configure() {
        // MAIN COMPONENT
        LogInPanel logInPanel = LogInPanel.getInstance();

        // SUB-COMPONENTS
        TitlePanel titlePanel = TitlePanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();

        // ADDING COMPONENTS
        logInPanel.setTitlePanel(titlePanel);
        logInPanel.setMenuPanel(menuPanel);

        // INITIALIZATION
        logInPanel.init();
    }
}
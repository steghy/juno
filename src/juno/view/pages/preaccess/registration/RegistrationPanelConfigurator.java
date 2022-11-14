package juno.view.pages.preaccess.registration;

import juno.view.pages.preaccess.registration.menu.MenuPanel;
import juno.view.pages.preaccess.registration.title.TitlePanel;

public class RegistrationPanelConfigurator {

    private RegistrationPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        RegistrationPanel registrationPanel = RegistrationPanel.getInstance();

        // SUB-COMPONENTS
        TitlePanel titlePanel = TitlePanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();

        // ADDING COMPONENTS
        registrationPanel.setTitlePanel(titlePanel);
        registrationPanel.setMenuPanel(menuPanel);

        // INITIALIZATION
        registrationPanel.init();
    }
}
package juno.view.pages.preaccess.card;

import juno.view.pages.preaccess.access.AccessPanel;
import juno.view.pages.preaccess.welcome.WelcomePanel;

public class PreAccessCardPanelConfigurator {

    private PreAccessCardPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        PreAccessCardPanel preAccessCardPanel = PreAccessCardPanel.getInstance();

        // SUB-COMPONENTS
        WelcomePanel welcomePanel = WelcomePanel.getInstance();
        AccessPanel accessPanel = AccessPanel.getInstance();

        // ADDING COMPONENTS
        preAccessCardPanel.setWelcomePanel(welcomePanel);
        preAccessCardPanel.setAccessPanel(accessPanel);

        // INITIALIZATION
        preAccessCardPanel.init();
    }
}
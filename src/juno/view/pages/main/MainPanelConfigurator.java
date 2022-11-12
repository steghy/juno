package juno.view.pages.main;

import juno.view.logo.LogoPanel;
import juno.view.pages.main.menu.MenuPanel;

public class MainPanelConfigurator {

    private MainPanelConfigurator() {}

    public static void configure() {
        MainPanel mainPanel = MainPanel.getInstance();

        LogoPanel logoPanel = LogoPanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();

        mainPanel.setTitlePanel(logoPanel);
        mainPanel.setMenuPanel(menuPanel);

        mainPanel.init();
    }
}

package juno.view.pages.mainPanel;

import juno.view.logo.LogoPanel;
import juno.view.pages.mainPanel.menuPanel.MenuPanel;

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

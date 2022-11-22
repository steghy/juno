package juno.view.pages.main;

import juno.view.pages.main.title.TitlePanel;
import juno.view.pages.main.menu.MenuPanel;

public class MainPanelConfigurator {

    private MainPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        MainPanel mainPanel = MainPanel.getInstance();

        // SUB COMPONENTS
        TitlePanel logoPanel = TitlePanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();

        // ADDING COMPONENTS
        mainPanel.setTitlePanel(logoPanel);
        mainPanel.setMenuPanel(menuPanel);

        // INITIALIZATION
        mainPanel.init();
    }
}

package juno.view.pages.mainPanel;

import juno.view.pages.mainPanel.menuPanel.MenuPanelConfigurator;

public class MainPanelInitializer {

    private MainPanelInitializer() {}

    public static void initialize() {
        MenuPanelConfigurator.configure();
        MainPanelConfigurator.configure();
        MainCardPanelConfigurator.configure();
    }
}

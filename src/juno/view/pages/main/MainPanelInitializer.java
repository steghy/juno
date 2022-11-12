package juno.view.pages.main;

import juno.view.logo.LogoPanelConfigurator;
import juno.view.pages.main.card.MainCardPanelConfigurator;
import juno.view.pages.main.menu.MenuPanelConfigurator;

public class MainPanelInitializer {

    private MainPanelInitializer() {}

    public static void initialize() {
        MenuPanelConfigurator.configure();
        MainPanelConfigurator.configure();
        LogoPanelConfigurator.configure();
        MainCardPanelConfigurator.configure();
    }
}

package juno.view.pages.main;

import juno.view.pages.main.title.TitlePanelConfigurator;
import juno.view.pages.main.card.MainCardPanelConfigurator;
import juno.view.pages.main.menu.MenuPanelConfigurator;

public class MainPanelInitializer {

    private MainPanelInitializer() {}

    public static void initialize() {
        // MAIN COMPONENT CONFIGURATION
        MainPanelConfigurator.configure();

        // SUB COMPONENT CONFIGURATION
        TitlePanelConfigurator.configure();
        MenuPanelConfigurator.configure();

        // CARD PANEL CONFIGURATION
        MainCardPanelConfigurator.configure();
    }
}
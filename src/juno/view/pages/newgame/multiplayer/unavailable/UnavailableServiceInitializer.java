package juno.view.pages.newgame.multiplayer.unavailable;

import juno.view.pages.newgame.multiplayer.unavailable.menu.MenuPanelConfigurator;
import juno.view.pages.newgame.multiplayer.unavailable.title.TitlePanelConfigurator;

public class UnavailableServiceInitializer {

    private UnavailableServiceInitializer() {}

    public static void initialize() {
        // SUB COMPONENTS CONFIGURATION
        MenuPanelConfigurator.configure();
        TitlePanelConfigurator.configure();

        // MAIN COMPONENT CONFIGURATION
        UnavailableServicePanelConfigurator.configure();
    }
}

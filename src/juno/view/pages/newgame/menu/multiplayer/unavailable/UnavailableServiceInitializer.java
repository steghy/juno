package juno.view.pages.newgame.menu.multiplayer.unavailable;

import juno.view.pages.newgame.menu.multiplayer.unavailable.menu.MenuPanelConfigurator;
import juno.view.pages.newgame.menu.multiplayer.unavailable.title.TitlePanelConfigurator;

public class UnavailableServiceInitializer {

    private UnavailableServiceInitializer() {}

    public static void initialize() {
        MenuPanelConfigurator.configure();
        TitlePanelConfigurator.configure();
        UnavailableServicePanelConfigurator.configure();
    }
}

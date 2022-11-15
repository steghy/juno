package juno.view.pages.newgame.singleplayer.players;

import juno.view.pages.newgame.singleplayer.players.menu.MenuPanelConfigurator;
import juno.view.pages.newgame.singleplayer.players.title.TitlePanelConfigurator;

public class PlayersNumberInitializer {

    private PlayersNumberInitializer() {}

    public static void initialize() {
        // SUB COMPONENTS CONFIGURATION
        TitlePanelConfigurator.configure();
        MenuPanelConfigurator.configure();

        // MAIN COMPONENT CONFIGURATION
        PlayersNumberPanelConfigurator.configure();
    }
}

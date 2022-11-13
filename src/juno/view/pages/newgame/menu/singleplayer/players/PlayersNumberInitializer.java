package juno.view.pages.newgame.menu.singleplayer.players;

import juno.view.pages.newgame.menu.singleplayer.players.menu.MenuPanelConfigurator;
import juno.view.pages.newgame.menu.singleplayer.players.title.TitlePanelConfigurator;

public class PlayersNumberInitializer {

    private PlayersNumberInitializer() {}

    public static void initialize() {
        TitlePanelConfigurator.configure();
        MenuPanelConfigurator.configure();
        PlayersNumberPanelConfigurator.configure();
    }
}

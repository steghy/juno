package juno.view.pages.newgame.menu.singleplayer;

import juno.view.pages.newgame.menu.singleplayer.card.SinglePlayerCardPanelConfigurator;
import juno.view.pages.newgame.menu.singleplayer.menu.MenuPanelConfigurator;
import juno.view.pages.newgame.menu.singleplayer.menu.difficulty.DifficultyPanelConfigurator;
import juno.view.pages.newgame.menu.singleplayer.menu.playersNumber.PlayersNumberPanelConfigurator;
import juno.view.pages.newgame.menu.singleplayer.title.TitlePanelConfigurator;

public class SinglePlayerInitializer {

    private SinglePlayerInitializer() {}

    public static void initialize() {
        // SUB-COMPONENTS CONFIGURATIONS
        PlayersNumberPanelConfigurator.configure();
        DifficultyPanelConfigurator.configure();

        // MAIN COMPONENTS CONFIGURATION
        MenuPanelConfigurator.configure();
        TitlePanelConfigurator.configure();
        SinglePlayerPanelConfigurator.configure();
        SinglePlayerCardPanelConfigurator.configure();
    }
}

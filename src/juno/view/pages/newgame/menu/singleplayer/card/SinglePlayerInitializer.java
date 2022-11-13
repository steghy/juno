package juno.view.pages.newgame.menu.singleplayer.card;

import juno.view.pages.newgame.menu.singleplayer.difficulty.DifficultyInitializer;
import juno.view.pages.newgame.menu.singleplayer.players.PlayersNumberInitializer;

public class SinglePlayerInitializer {

    private SinglePlayerInitializer() {}

    public static void initialize() {
        // SUB-COMPONENTS INITIALIZATION
        DifficultyInitializer.initialize();
        PlayersNumberInitializer.initialize();

        // MAIN-COMPONENT CONFIGURATION
        SinglePlayerCardPanelConfigurator.configure();
    }
}

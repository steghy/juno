package juno.view.pages.newgame.menu.singleplayer.card;

import juno.view.pages.newgame.menu.singleplayer.difficulty.DifficultyInitializer;
import juno.view.pages.newgame.menu.singleplayer.match.MatchInitializer;
import juno.view.pages.newgame.menu.singleplayer.mode.ModeInitializer;
import juno.view.pages.newgame.menu.singleplayer.players.PlayersNumberInitializer;

public class SinglePlayerInitializer {

    private SinglePlayerInitializer() {}

    public static void initialize() {
        // SUB-COMPONENTS INITIALIZATION
        DifficultyInitializer.initialize();
        PlayersNumberInitializer.initialize();
        ModeInitializer.initialize();
        MatchInitializer.initialize();

        // MAIN-COMPONENT CONFIGURATION
        SinglePlayerCardPanelConfigurator.configure();
    }
}

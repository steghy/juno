package juno.view.pages.newgame.singleplayer;

import juno.view.pages.newgame.singleplayer.card.SinglePlayerCardPanelConfigurator;
import juno.view.pages.newgame.singleplayer.difficulty.DifficultyInitializer;
import juno.view.pages.newgame.singleplayer.match.MatchInitializer;
import juno.view.pages.newgame.singleplayer.mode.ModeInitializer;
import juno.view.pages.newgame.singleplayer.players.PlayersNumberInitializer;

public class SinglePlayerInitializer {

    private SinglePlayerInitializer() {}

    public static void initialize() {
        // SUB COMPONENTS INITIALIZATION
        DifficultyInitializer.initialize();
        MatchInitializer.initialize();
        ModeInitializer.initialize();
        PlayersNumberInitializer.initialize();

        // CARD PANEL CONFIGURATION
        SinglePlayerCardPanelConfigurator.configure();
    }
}

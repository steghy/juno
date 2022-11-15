package juno.view.pages.newgame.singleplayer.card;

import juno.view.pages.newgame.singleplayer.difficulty.DifficultyPanel;
import juno.view.pages.newgame.singleplayer.mode.ModePanel;
import juno.view.pages.newgame.singleplayer.players.PlayersNumberPanel;

import javax.swing.*;

public class SinglePlayerCardPanelConfigurator {

    private SinglePlayerCardPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        SinglePlayerCardPanel singlePlayerCardPanel = SinglePlayerCardPanel.getInstance();

        // SUB COMPONENTS
        PlayersNumberPanel playersNumberPanel = PlayersNumberPanel.getInstance();
        DifficultyPanel difficultyPanel = DifficultyPanel.getInstance();
        ModePanel modePanel = ModePanel.getInstance();

        // ADDING COMPONENTS
        singlePlayerCardPanel.setPlayersNumberPanel(playersNumberPanel);
        singlePlayerCardPanel.setDifficultyPanel(difficultyPanel);
        singlePlayerCardPanel.setModePanel(modePanel);
        singlePlayerCardPanel.setMatchPanel(new JPanel());

        // MAIN COMPONENT INITIALIZATION
        singlePlayerCardPanel.init();
    }
}
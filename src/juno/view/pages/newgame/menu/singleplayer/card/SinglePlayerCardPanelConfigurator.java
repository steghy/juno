package juno.view.pages.newgame.menu.singleplayer.card;

import juno.view.pages.newgame.menu.singleplayer.difficulty.DifficultyPanel;
import juno.view.pages.newgame.menu.singleplayer.players.PlayersNumberPanel;

import javax.swing.*;

public class SinglePlayerCardPanelConfigurator {

    private SinglePlayerCardPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        SinglePlayerCardPanel singlePlayerCardPanel = SinglePlayerCardPanel.getInstance();

        // SUB-COMPONENTS
        PlayersNumberPanel playersNumberPanel = PlayersNumberPanel.getInstance();
        DifficultyPanel difficultyPanel = DifficultyPanel.getInstance();

        // ADDING COMPONENTS
        singlePlayerCardPanel.setPlayersNumberPanel(playersNumberPanel);
        singlePlayerCardPanel.setDifficultyPanel(difficultyPanel);
        singlePlayerCardPanel.setModePanel(new JPanel());
        singlePlayerCardPanel.setMatchPanel(new JPanel());

        // INITIALIZATION
        singlePlayerCardPanel.init();
    }
}
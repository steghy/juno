package juno.view.pages.main.card;

import juno.view.pages.main.MainPanel;
import juno.view.pages.newgame.card.NewGameCardPanel;
import juno.view.pages.options.OptionsPanel;
import juno.view.pages.score.ScorePanel;

public class MainCardPanelConfigurator {

    private MainCardPanelConfigurator() {}

    public static void configure() {
        MainCardPanel cardPanel = MainCardPanel.getInstance();

        MainPanel mainPanel = MainPanel.getInstance();
        NewGameCardPanel newGameCardPanel = NewGameCardPanel.getInstance();
        ScorePanel scorePanel = ScorePanel.getInstance();
        OptionsPanel optionsPanel = OptionsPanel.getInstance();

        cardPanel.setMainPanel(mainPanel);
        cardPanel.setNewGamePanel(newGameCardPanel);
        cardPanel.setScorePanel(scorePanel);
        cardPanel.setOptionsPanel(optionsPanel);

        cardPanel.init();
    }
}

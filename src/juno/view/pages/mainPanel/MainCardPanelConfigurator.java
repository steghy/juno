package juno.view.pages.mainPanel;

import juno.view.pages.newGamePanel.NewGameCardPanel;
import juno.view.pages.optionsPanel.OptionsPanel;
import juno.view.pages.scorePanel.ScorePanel;

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

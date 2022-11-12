package juno.view.pages.newGamePanel;

import juno.view.pages.newGamePanel.multiplayer.MultiplayerPanel;
import juno.view.pages.newGamePanel.singleplayer.SinglePlayerCardPanel;

public class NewGameCardPanelConfigurator {

    private NewGameCardPanelConfigurator() {}

    public static void configure() {
        NewGameCardPanel newGameCardPanel = NewGameCardPanel.getInstance();

        NewGamePanel newGamePanel = NewGamePanel.getInstance();
        MultiplayerPanel multiplayerPanel = MultiplayerPanel.getInstance();
        SinglePlayerCardPanel singlePlayerCardPanel = SinglePlayerCardPanel.getInstance();

        newGameCardPanel.setNewGamePanel(newGamePanel);
        newGameCardPanel.setSinglePlayerPanel(singlePlayerCardPanel);
        newGameCardPanel.setMultiplayerPanel(multiplayerPanel);

        newGameCardPanel.init();
    }
}

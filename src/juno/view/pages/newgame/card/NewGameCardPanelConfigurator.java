package juno.view.pages.newgame.card;

import juno.view.pages.newgame.NewGamePanel;
import juno.view.pages.newgame.multiplayer.card.MultiplayerCardPanel;
import juno.view.pages.newgame.singleplayer.card.SinglePlayerCardPanel;

public class NewGameCardPanelConfigurator {

    private NewGameCardPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        NewGameCardPanel newGameCardPanel = NewGameCardPanel.getInstance();

        // SUB-COMPONENTS
        NewGamePanel newGamePanel = NewGamePanel.getInstance();
        MultiplayerCardPanel multiplayerCardPanel = MultiplayerCardPanel.getInstance();
        SinglePlayerCardPanel singlePlayerCardPanel = SinglePlayerCardPanel.getInstance();

        // ADDING COMPONENTS
        newGameCardPanel.setNewGamePanel(newGamePanel);
        newGameCardPanel.setSinglePlayerPanel(singlePlayerCardPanel);
        newGameCardPanel.setMultiplayerPanel(multiplayerCardPanel);

        // INITIALIZATION
        newGameCardPanel.init();
    }
}

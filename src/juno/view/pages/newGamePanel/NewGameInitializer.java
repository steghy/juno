package juno.view.pages.newGamePanel;

import juno.view.pages.newGamePanel.multiplayer.MultiplayerInitializer;
import juno.view.pages.newGamePanel.singleplayer.SinglePlayerInitializer;

public class NewGameInitializer {

    private NewGameInitializer() {}

    public static void initialize() {
        NewGamePanelConfigurator.configure();
        SinglePlayerInitializer.initialize();
        MultiplayerInitializer.initialize();
        NewGameCardPanelConfigurator.configure();
    }
}

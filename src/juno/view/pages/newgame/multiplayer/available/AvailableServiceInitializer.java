package juno.view.pages.newgame.multiplayer.available;

import juno.view.pages.newgame.multiplayer.card.MultiplayerCardPanelConfigurator;

public class AvailableServiceInitializer {

    private AvailableServiceInitializer() {}

    public static void initialize() {
        MultiplayerCardPanelConfigurator.configure();
    }
}

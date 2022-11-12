package juno.view.pages.newgame.menu.multiplayer.available;

import juno.view.pages.newgame.menu.multiplayer.card.MultiplayerCardPanelConfigurator;

public class AvailableServiceInitializer {

    private AvailableServiceInitializer() {}

    public static void initialize() {
        MultiplayerCardPanelConfigurator.configure();
    }
}

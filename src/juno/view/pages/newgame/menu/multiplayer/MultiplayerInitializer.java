package juno.view.pages.newgame.menu.multiplayer;

import juno.view.pages.newgame.menu.multiplayer.available.AvailableServiceInitializer;
import juno.view.pages.newgame.menu.multiplayer.card.MultiplayerCardPanelConfigurator;
import juno.view.pages.newgame.menu.multiplayer.unavailable.UnavailableServiceInitializer;

public class MultiplayerInitializer {

    private MultiplayerInitializer() {}

    public static void initialize() {
        AvailableServiceInitializer.initialize();
        UnavailableServiceInitializer.initialize();
        MultiplayerCardPanelConfigurator.configure();
    }
}

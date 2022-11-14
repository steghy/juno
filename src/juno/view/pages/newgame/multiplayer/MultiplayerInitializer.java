package juno.view.pages.newgame.multiplayer;

import juno.view.pages.newgame.multiplayer.available.AvailableServiceInitializer;
import juno.view.pages.newgame.multiplayer.card.MultiplayerCardPanelConfigurator;
import juno.view.pages.newgame.multiplayer.unavailable.UnavailableServiceInitializer;

public class MultiplayerInitializer {

    private MultiplayerInitializer() {}

    public static void initialize() {
        AvailableServiceInitializer.initialize();
        UnavailableServiceInitializer.initialize();
        MultiplayerCardPanelConfigurator.configure();
    }
}

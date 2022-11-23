package juno.view.pages.newgame.multiplayer.card;

import juno.view.pages.newgame.multiplayer.available.AvailableServiceInitializer;
import juno.view.pages.newgame.multiplayer.unavailable.UnavailableServiceInitializer;

public class MultiplayerInitializer {

    private MultiplayerInitializer() {}

    public static void initialize() {
        // SUB COMPONENTS CONFIGURATION
        AvailableServiceInitializer.initialize();
        UnavailableServiceInitializer.initialize();

        // MAIN COMPONENT CONFIGURATION
        MultiplayerCardPanelConfigurator.configure();
    }
}
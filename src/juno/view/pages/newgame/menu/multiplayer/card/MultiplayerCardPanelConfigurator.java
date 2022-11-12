package juno.view.pages.newgame.menu.multiplayer.card;

import juno.view.pages.newgame.menu.multiplayer.available.AvailableServicePanel;
import juno.view.pages.newgame.menu.multiplayer.unavailable.UnavailableServicePanel;

public class MultiplayerCardPanelConfigurator {

    private MultiplayerCardPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        MultiplayerCardPanel multiplayerCardPanel = MultiplayerCardPanel.getInstance();

        // SUB-COMPONENTS
        AvailableServicePanel multiplayerPanel = AvailableServicePanel.getInstance();
        UnavailableServicePanel unavailableServicePanel = UnavailableServicePanel.getInstance();

        // ADDING COMPONENTS
        multiplayerCardPanel.setMultiplayerPanel(multiplayerPanel);
        multiplayerCardPanel.setUnavailableServicePanel(unavailableServicePanel);

        // INITIALIZATION
        multiplayerCardPanel.init();
    }
}

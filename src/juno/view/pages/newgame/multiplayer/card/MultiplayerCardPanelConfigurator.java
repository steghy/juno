package juno.view.pages.newgame.multiplayer.card;

import juno.view.pages.newgame.multiplayer.available.AvailableServicePanel;
import juno.view.pages.newgame.multiplayer.unavailable.UnavailableServicePanel;

public class MultiplayerCardPanelConfigurator {

    private MultiplayerCardPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        MultiplayerCardPanel multiplayerCardPanel = MultiplayerCardPanel.getInstance();

        // SUB-COMPONENTS
        AvailableServicePanel availableServicePanel = AvailableServicePanel.getInstance();
        UnavailableServicePanel unavailableServicePanel = UnavailableServicePanel.getInstance();

        // ADDING COMPONENTS
        multiplayerCardPanel.setAvailableServicePanel(availableServicePanel);
        multiplayerCardPanel.setUnavailableServicePanel(unavailableServicePanel);

        // INITIALIZATION
        multiplayerCardPanel.init();
    }
}

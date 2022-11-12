package juno.view.pages.newGamePanel.multiplayer;

import java.awt.*;

public class MultiplayerCardPanelConfigurator {

    private MultiplayerCardPanelConfigurator() {}

    public static void configure() {
        MultiplayerCardPanel multiplayerCardPanel = MultiplayerCardPanel.getInstance();

        MultiplayerPanel multiplayerPanel = MultiplayerPanel.getInstance();
        UnavailableServicePanel unavailableServicePanel = UnavailableServicePanel.getInstance();

        multiplayerCardPanel.setMultiplayerPanel(multiplayerPanel);
        multiplayerCardPanel.setUnavailableServicePanel(unavailableServicePanel);

        multiplayerCardPanel.init();

        //@TEMPORARY
        LayoutManager layoutManager = multiplayerCardPanel.getLayout();
        if(layoutManager instanceof CardLayout cardLayout) {
            cardLayout.show(multiplayerCardPanel, MultiplayerCardPanel.UNAVAILABLE_SERVICE);
        } else {
            throw new IllegalArgumentException("Invalid LayoutManager for 'MultiplayerCardPanel'");
        }
    }
}

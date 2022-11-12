package juno.view.pages.newgame.menu.singleplayer.card;

import juno.view.pages.newgame.menu.singleplayer.SinglePlayerPanel;

import javax.swing.*;

public class SinglePlayerCardPanelConfigurator {

    private SinglePlayerCardPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        SinglePlayerCardPanel singlePlayerCardPanel = SinglePlayerCardPanel.getInstance();

        // SUB-COMPONENTS
        SinglePlayerPanel singlePlayerPanel = SinglePlayerPanel.getInstance();

        // ADDING COMPONENTS
        singlePlayerCardPanel.setMainPanel(singlePlayerPanel);
        singlePlayerCardPanel.setModePanel(new JPanel());

        // INITIALIZATION
        singlePlayerCardPanel.init();
    }
}
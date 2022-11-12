package juno.view.pages.newGamePanel.singleplayer.menuPanel.playersNumber;

import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.util.ImageResizer;

import javax.swing.*;

public class PlayersNumberPanelConfigurator {

    private PlayersNumberPanelConfigurator() {}

    public static void configure() {

        PlayersNumberPanel playerNumbersPanel = PlayersNumberPanel.getInstance();

        AbstractButton twoPlayers = ButtonFactory.createButton(ButtonLibrary.TWO_PLAYERS);
        AbstractButton threePlayers = ButtonFactory.createButton(ButtonLibrary.THREE_PLAYERS);
        AbstractButton fourPlayers = ButtonFactory.createButton(ButtonLibrary.FOUR_PLAYERS);

        // RESIZE IMAGES
        ImageResizer.resize(twoPlayers, 2.0);
        ImageResizer.resize(threePlayers, 2.0);
        ImageResizer.resize(fourPlayers, 2.0);

        // ACTION LISTENERS
        twoPlayers.addActionListener(null);
        threePlayers.addActionListener(null);
        fourPlayers.addActionListener(null);

        // ADDING COMPONENTS
        playerNumbersPanel.setTwoPlayers(twoPlayers);
        playerNumbersPanel.setThreePlayers(threePlayers);
        playerNumbersPanel.setFourPlayers(fourPlayers);

        // INITIALIZATION
        playerNumbersPanel.init();
    }
}
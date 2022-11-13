package juno.view.pages.newgame.menu.singleplayer.menu.playersNumber;

import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class PlayersNumberPanelConfigurator {

    private PlayersNumberPanelConfigurator() {}

    public static void configure() {

        PlayersNumberPanel playerNumbersPanel = PlayersNumberPanel.getInstance();

        AbstractButton twoPlayers = ButtonFactory.createButton(ButtonLibrary.TWO_PLAYERS);
        AbstractButton threePlayers = ButtonFactory.createButton(ButtonLibrary.THREE_PLAYERS);
        AbstractButton fourPlayers = ButtonFactory.createButton(ButtonLibrary.FOUR_PLAYERS);

        // RESIZE IMAGES
        ImageResizer.resize(twoPlayers, 3.0);
        ImageResizer.resize(threePlayers, 3.0);
        ImageResizer.resize(fourPlayers, 3.0);

        // ACTION LISTENERS
        twoPlayers.addActionListener(null);
        threePlayers.addActionListener(null);
        fourPlayers.addActionListener(null);

        // BORDER SETTING
        RoundedBorder roundedBorder = new RoundedBorder(50, 2, null, Color.WHITE);
        // playerNumbersPanel.setBorder(roundedBorder);

        // ADDING COMPONENTS
        playerNumbersPanel.setTwoPlayers(twoPlayers);
        playerNumbersPanel.setThreePlayers(threePlayers);
        playerNumbersPanel.setFourPlayers(fourPlayers);

        // INITIALIZATION
        playerNumbersPanel.init();
    }
}
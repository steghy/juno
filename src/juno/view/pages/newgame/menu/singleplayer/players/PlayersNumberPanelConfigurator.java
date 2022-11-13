package juno.view.pages.newgame.menu.singleplayer.players;

import juno.view.pages.newgame.menu.singleplayer.players.menu.MenuPanel;
import juno.view.pages.newgame.menu.singleplayer.players.title.TitlePanel;

import javax.swing.*;

public class PlayersNumberPanelConfigurator {

    private PlayersNumberPanelConfigurator() {}

    public static void configure() {
        // MAIN-COMPONENTS
        PlayersNumberPanel playerNumbersPanel = PlayersNumberPanel.getInstance();

        // SUB-COMPONENTS
        MenuPanel menuPanel = MenuPanel.getInstance();
        TitlePanel titlePanel = TitlePanel.getInstance();

        // ADDING COMPONENTS
        playerNumbersPanel.setTitlePanel(titlePanel);
        playerNumbersPanel.setMenuPanel(menuPanel);

        // INITIALIZATION
        playerNumbersPanel.init();
    }
}
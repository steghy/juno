package juno.view.pages.newgame.singleplayer.players;

import juno.view.pages.newgame.singleplayer.players.menu.MenuPanel;
import juno.view.pages.newgame.singleplayer.players.title.TitlePanel;

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
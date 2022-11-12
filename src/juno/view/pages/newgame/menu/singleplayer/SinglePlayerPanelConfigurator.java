package juno.view.pages.newgame.menu.singleplayer;

import juno.view.pages.newgame.menu.singleplayer.menu.MenuPanel;
import juno.view.pages.newgame.menu.singleplayer.title.TitlePanel;

public class SinglePlayerPanelConfigurator {

    private SinglePlayerPanelConfigurator() {}

    public static void configure() {
        // MAIN-COMPONENT
        SinglePlayerPanel singlePlayerPanel = SinglePlayerPanel.getInstance();

        // SUB-COMPONENTS
        TitlePanel titlePanel = TitlePanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();

        // ADDING COMPONENTS
        singlePlayerPanel.setTitlePanel(titlePanel);
        singlePlayerPanel.setMenuPanel(menuPanel);

        // INITIALIZATION
        singlePlayerPanel.init();
    }
}

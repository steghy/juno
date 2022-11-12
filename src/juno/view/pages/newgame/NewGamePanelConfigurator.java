package juno.view.pages.newgame;

import juno.view.pages.newgame.menu.MenuPanel;
import juno.view.pages.newgame.title.TitlePanel;

public class NewGamePanelConfigurator {

    private NewGamePanelConfigurator() {}

    public static void configure() {
        // COMPONENT
        NewGamePanel newGamePanel = NewGamePanel.getInstance();

        // SUB-COMPONENTS
        TitlePanel titlePanel = TitlePanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();

        // ADDING COMPONENTS
        newGamePanel.setTitlePanel(titlePanel);
        newGamePanel.setMenuPanel(menuPanel);

        // INITIALIZATION
        newGamePanel.init();
    }

}

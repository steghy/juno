package juno.view.pages.newgame.singleplayer.difficulty;

import juno.view.pages.newgame.singleplayer.difficulty.menu.MenuPanel;
import juno.view.pages.newgame.singleplayer.difficulty.title.TitlePanel;

public class DifficultyPanelConfigurator {

    private DifficultyPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        DifficultyPanel difficultyPanel = DifficultyPanel.getInstance();

        // SUB-COMPONENTS
        TitlePanel titlePanel = TitlePanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();

        // ADDING COMPONENT
        difficultyPanel.setTitlePanel(titlePanel);
        difficultyPanel.setMenuPanel(menuPanel);

        // INITIALIZATION
        difficultyPanel.init();
    }
}
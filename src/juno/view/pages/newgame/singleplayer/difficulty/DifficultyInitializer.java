package juno.view.pages.newgame.singleplayer.difficulty;

import juno.view.pages.newgame.singleplayer.difficulty.menu.MenuPanelConfigurator;
import juno.view.pages.newgame.singleplayer.difficulty.title.TitlePanelConfigurator;

public class DifficultyInitializer {

    private DifficultyInitializer() {}

    public static void initialize() {
        // SUB COMPONENTS CONFIGURATION
        TitlePanelConfigurator.configure();
        MenuPanelConfigurator.configure();

        // MAIN COMPONENT CONFIGURATION
        DifficultyPanelConfigurator.configure();
    }
}
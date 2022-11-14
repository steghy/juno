package juno.view.pages.newgame.singleplayer.difficulty;

import juno.view.pages.newgame.singleplayer.difficulty.menu.MenuPanelConfigurator;
import juno.view.pages.newgame.singleplayer.difficulty.title.TitlePanelConfigurator;

public class DifficultyInitializer {

    private DifficultyInitializer() {}

    public static void initialize() {
        TitlePanelConfigurator.configure();
        MenuPanelConfigurator.configure();
        DifficultyPanelConfigurator.configure();
    }
}

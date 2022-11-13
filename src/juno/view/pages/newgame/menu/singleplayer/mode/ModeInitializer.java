package juno.view.pages.newgame.menu.singleplayer.mode;

import juno.view.pages.newgame.menu.singleplayer.mode.menu.MenuPanelConfigurator;
import juno.view.pages.newgame.menu.singleplayer.mode.title.TitlePanelConfigurator;

public class ModeInitializer {

    private ModeInitializer() {}

    public static void initialize() {
        // SUB-COMPONENTS
        TitlePanelConfigurator.configure();
        MenuPanelConfigurator.configure();

        // MAIN-COMPONENT
        ModePanelConfigurator.configure();
    }
}

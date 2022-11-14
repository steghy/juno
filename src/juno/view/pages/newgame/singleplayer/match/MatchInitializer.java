package juno.view.pages.newgame.singleplayer.match;

import juno.view.pages.newgame.singleplayer.match.menu.MenuPanelConfigurator;
import juno.view.pages.newgame.singleplayer.match.title.TitlePanelConfigurator;

public class MatchInitializer {

    private MatchInitializer() {}

    public static void initialize() {
        // SUB-COMPONENTS
        MenuPanelConfigurator.configure();
        TitlePanelConfigurator.configure();

        // MAIN-COMPONENT
        MatchPanelConfigurator.configure();
    }
}
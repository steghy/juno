package juno.view.pages.newgame;

// MAIN COMPONENT
import juno.view.pages.newgame.card.NewGameCardPanelConfigurator;
import juno.view.pages.newgame.menu.MenuPanelConfigurator;
import juno.view.pages.newgame.title.TitlePanelConfigurator;

// SUB COMPONENT
import juno.view.pages.newgame.menu.multiplayer.MultiplayerInitializer;
import juno.view.pages.newgame.menu.singleplayer.SinglePlayerInitializer;


public class NewGameInitializer {

    private NewGameInitializer() {}

    public static void initialize() {
        // SUB-COMPONENT INITIALIZATION
        SinglePlayerInitializer.initialize();
        MultiplayerInitializer.initialize();

        // MAIN-COMPONENT CONFIGURATION
        MenuPanelConfigurator.configure();
        TitlePanelConfigurator.configure();
        NewGamePanelConfigurator.configure();
        NewGameCardPanelConfigurator.configure();
    }
}

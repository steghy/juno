package juno.init;

import juno.view.frame.FrameInitializer;
import juno.view.pages.card.TopCardPanelConfigurator;
import juno.view.pages.main.MainPanelInitializer;
import juno.view.pages.newgame.NewGameInitializer;
import juno.view.pages.options.OptionsInitializer;
import juno.view.pages.preaccess.PreAccessInitializer;
import juno.view.pages.score.ScorePanelInitializer;

public class ViewInitializer {

    private ViewInitializer() {}

    public static void initialize() {
        // NEW GAME SECTION
        NewGameInitializer.initialize();

        // SCORE SECTION
        ScorePanelInitializer.initialize();

        // OPTIONS SECTION
        OptionsInitializer.initialize();

        // MAIN PANEL SECTION
        MainPanelInitializer.initialize();

        // PRE ACCESS PANEL
        PreAccessInitializer.initialize();

        // TOP CARD PANEL CONFIGURATION
        TopCardPanelConfigurator.configure();

        // FRAME SECTION
        FrameInitializer.initializer();
    }
}
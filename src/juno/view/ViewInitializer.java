package juno.view;

import juno.view.frame.FrameInitializer;
import juno.view.pages.main.MainPanelInitializer;
import juno.view.pages.newgame.NewGameInitializer;
import juno.view.pages.options.OptionsInitializer;
import juno.view.pages.score.ScorePanelInitializer;

public class ViewInitializer {

    private ViewInitializer() {}

    public static void initialize() {
        // NEW GAME
        NewGameInitializer.initialize();

        // SCORE
        ScorePanelInitializer.initialize();

        // OPTIONS
        OptionsInitializer.initialize();

        // MAIN PANEL
        MainPanelInitializer.initialize();

        // FRAME
        FrameInitializer.initializer();
    }
}

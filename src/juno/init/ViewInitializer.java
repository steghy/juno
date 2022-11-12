package juno.init;

import juno.view.frame.FrameInitializer;
import juno.view.pages.mainPanel.MainPanelInitializer;
import juno.view.pages.newGamePanel.NewGameInitializer;
import juno.view.pages.optionsPanel.OptionsInitializer;
import juno.view.pages.scorePanel.ScorePanelInitializer;

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

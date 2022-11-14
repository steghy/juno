package juno.view.pages.newgame.singleplayer.match;

public class MatchPanelConfigurator {

    private MatchPanelConfigurator() {}

    public static void configure() {
        // MAIN-COMPONENT
        MatchPanel matchPanel = MatchPanel.getInstance();

        // INITIALIZATION
        matchPanel.init();
    }
}
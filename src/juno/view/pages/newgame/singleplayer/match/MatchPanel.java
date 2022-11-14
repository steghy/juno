package juno.view.pages.newgame.singleplayer.match;

import javax.swing.*;

public class MatchPanel extends JPanel {

    private static MatchPanel instance;

    private MatchPanel() {}

    public static MatchPanel getInstance() {
        if(instance == null) {
            instance = new MatchPanel();
        } return instance;
    }

    public void init() {}
}
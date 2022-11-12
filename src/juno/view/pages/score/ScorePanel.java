package juno.view.pages.score;

import javax.swing.*;

public class ScorePanel extends JPanel {

    private static ScorePanel instance;

    private ScorePanel() {}

    public static ScorePanel getInstance() {
        if(instance == null) {
            instance = new ScorePanel();
        } return instance;
    }

    public void init() {

    }
}

package juno.view.pages.newgame.menu.singleplayer.card;

import javax.swing.*;
import java.awt.*;

public class SinglePlayerCardPanel extends JPanel {

    public static final String PLAYERS_NUMBER_PANEL = "Players number panel";
    public static final String DIFFICULTY_PANEL = "Difficulty panel";
    public static final String MODE_PANEL = "Mode panel";
    public static final String MATCH_PANEL = "Match panel";

    private JPanel playersNumberPanel;
    private JPanel difficultyPanel;
    private JPanel modePanel;
    private JPanel matchPanel;

    private static SinglePlayerCardPanel instance;

    public static SinglePlayerCardPanel getInstance() {
        if(instance == null) {
            instance = new SinglePlayerCardPanel();
        } return instance;
    }

    public void init() {
        if(playersNumberPanel == null) {
            throw new IllegalArgumentException("Players number panel is null");
        } if(modePanel == null) {
            throw new IllegalArgumentException("Mode panel is null");
        } if(difficultyPanel == null) {
            throw new IllegalArgumentException("Difficulty panel is null");
        } if(matchPanel == null) {
            throw new IllegalArgumentException("Match panel is null");
        }

        setOpaque(false);
        setLayout(new CardLayout());
        add(playersNumberPanel, PLAYERS_NUMBER_PANEL);
        add(difficultyPanel, DIFFICULTY_PANEL);
        add(modePanel, MODE_PANEL);
        add(matchPanel, MATCH_PANEL);
    }

    public void setPlayersNumberPanel(JPanel playersNumberPanel) {
        this.playersNumberPanel = playersNumberPanel;
    }

    public void setModePanel(JPanel modePanel) {
        this.modePanel = modePanel;
    }

    public void setMatchPanel(JPanel matchPanel) {
        this.matchPanel = matchPanel;
    }

    public void setDifficultyPanel(JPanel difficultyPanel) {
        this.difficultyPanel = difficultyPanel;
    }

    public JPanel getPlayersNumberPanel() {
        return playersNumberPanel;
    }

    public JPanel getModePanel() {
        return modePanel;
    }

    public JPanel getMatchPanel() {
        return matchPanel;
    }

    public JPanel getDifficultyPanel() {
        return difficultyPanel;
    }
}
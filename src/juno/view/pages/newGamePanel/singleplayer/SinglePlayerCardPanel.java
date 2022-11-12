package juno.view.pages.newGamePanel.singleplayer;

import javax.swing.*;
import java.awt.*;

public class SinglePlayerCardPanel extends JPanel {

    public static final String DIFFICULTY_PANEL = "Difficulty panel";
    public static final String PLAYERS_NUMBER_PANEL = "Players number panel";

    private JPanel difficultyPanel;
    private JPanel playersNumberPanel;

    private static SinglePlayerCardPanel instance;

    public static SinglePlayerCardPanel getInstance() {
        if(instance == null) {
            instance = new SinglePlayerCardPanel();
        } return instance;
    }

    public void init() {
        if(difficultyPanel == null) {
            throw new IllegalArgumentException("Difficulty panel is null");
        } if(playersNumberPanel == null) {
            throw new IllegalArgumentException("Players number panel is null");
        }

        setOpaque(false);
        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);
        add(playersNumberPanel, PLAYERS_NUMBER_PANEL);
        add(difficultyPanel, DIFFICULTY_PANEL);
        cardLayout.show(this, PLAYERS_NUMBER_PANEL);
    }

    public void setDifficultyPanel(JPanel difficultyPanel) {
        this.difficultyPanel = difficultyPanel;
    }

    public void setPlayersNumberPanel(JPanel playersNumberPanel) {
        this.playersNumberPanel = playersNumberPanel;
    }

    public JPanel getDifficultyPanel() {
        return difficultyPanel;
    }

    public JPanel getPlayersNumberPanel() {
        return playersNumberPanel;
    }
}

package juno.view.frame;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {

    private JPanel mainPanel;
    private JPanel optionsPanel;
    private JPanel scorePanel;
    private JPanel newGamePanel;

    public static final String MAIN_PANEL = "Main panel";
    public static final String OPTIONS_PANEL = "Options panel";
    public static final String SCORE_PANEL = "Score panel";
    public static final String NEW_GAME_PANEL = "New game panel";

    private static CardPanel instance;

    private CardPanel() {}

    public static CardPanel getInstance() {
        if(instance == null) {
            instance = new CardPanel();
        } return instance;
    }

    public void init() {
        if(mainPanel == null) {
            throw new IllegalArgumentException("Main panel is null");
        } if(optionsPanel == null) {
            throw new IllegalArgumentException("Options panel is null");
        } if(scorePanel == null) {
            throw new IllegalArgumentException("Score panel is null");
        } if(newGamePanel == null) {
            throw new IllegalArgumentException("New game panel is null");
        }

        setOpaque(false);
        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);
        add(mainPanel, MAIN_PANEL);
        add(optionsPanel, OPTIONS_PANEL);
        add(scorePanel, SCORE_PANEL);
        add(newGamePanel, NEW_GAME_PANEL);
        // cardLayout.show(mainPanel, MAIN_PANEL);
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setOptionsPanel(JPanel optionsPanel) {
        this.optionsPanel = optionsPanel;
    }

    public void setScorePanel(JPanel scorePanel) {
        this.scorePanel = scorePanel;
    }

    public void setNewGamePanel(JPanel newGamePanel) {
        this.newGamePanel = newGamePanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getOptionsPanel() {
        return optionsPanel;
    }

    public JPanel getScorePanel() {
        return scorePanel;
    }

    public JPanel getNewGamePanel() {
        return newGamePanel;
    }
}
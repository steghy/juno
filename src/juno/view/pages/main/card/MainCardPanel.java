package juno.view.pages.main.card;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MainCardPanel
        extends JPanel {

    private JPanel mainPanel;
    private JPanel optionsPanel;
    private JPanel scorePanel;
    private JPanel newGamePanel;

    public static final String MAIN_PANEL = "Main panel";
    public static final String OPTIONS_PANEL = "Options panel";
    public static final String SCORE_PANEL = "Score panel";
    public static final String NEW_GAME_PANEL = "New game panel";

    private static MainCardPanel instance;

    private MainCardPanel() {}

    public static MainCardPanel getInstance() {
        if(instance == null) instance = new MainCardPanel();
        return instance;
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
        setLayout(new CardLayout());
        add(mainPanel, MAIN_PANEL);
        add(optionsPanel, OPTIONS_PANEL);
        add(scorePanel, SCORE_PANEL);
        add(newGamePanel, NEW_GAME_PANEL);
    }

    public void setMainPanel(@NotNull JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setOptionsPanel(@NotNull JPanel optionsPanel) {
        this.optionsPanel = optionsPanel;
    }

    public void setScorePanel(@NotNull JPanel scorePanel) {
        this.scorePanel = scorePanel;
    }

    public void setNewGamePanel(@NotNull JPanel newGamePanel) {
        this.newGamePanel = newGamePanel;
    }
}
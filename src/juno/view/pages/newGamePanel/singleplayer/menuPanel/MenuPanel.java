package juno.view.pages.newGamePanel.singleplayer.menuPanel;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private JPanel difficultyPanel;
    private JPanel playersNumberPanel;

    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) {
            instance = new MenuPanel();
        } return instance;
    }

    public void init() {
        if(difficultyPanel == null) {
            throw new IllegalArgumentException("Difficulty panel is null");
        } if(playersNumberPanel == null) {
            throw new IllegalArgumentException("Players number panel is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // DIFFICULTY PANEL
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(difficultyPanel, gbc);

        // BACK BUTTON
        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(playersNumberPanel, gbc);
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
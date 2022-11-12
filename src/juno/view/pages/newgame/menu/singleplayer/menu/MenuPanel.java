package juno.view.pages.newgame.menu.singleplayer.menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private JPanel difficultyPanel;
    private JPanel playersNumberPanel;
    private AbstractButton backButton;

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
        } if(backButton == null) {
            throw new IllegalArgumentException("Back button is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // DIFFICULTY PANEL
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(20,0,30,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(difficultyPanel, gbc);

        // PLAYERS NUMBER PANEL
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,30,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(playersNumberPanel, gbc);

        // BACK BUTTON
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(25,0,0,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(backButton, gbc);
    }

    public void setDifficultyPanel(JPanel difficultyPanel) {
        this.difficultyPanel = difficultyPanel;
    }

    public void setPlayersNumberPanel(JPanel playersNumberPanel) {
        this.playersNumberPanel = playersNumberPanel;
    }

    public void setBackButton(AbstractButton backButton) {
        this.backButton = backButton;
    }

    public JPanel getDifficultyPanel() {
        return difficultyPanel;
    }

    public JPanel getPlayersNumberPanel() {
        return playersNumberPanel;
    }

    public AbstractButton getBackButton() {
        return backButton;
    }
}
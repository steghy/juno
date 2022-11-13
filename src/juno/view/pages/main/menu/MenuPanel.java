package juno.view.pages.main.menu;

import juno.view.util.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private AbstractButton newGameButton;
    private AbstractButton optionsButton;
    private AbstractButton scoreButton;
    private AbstractButton exitButton;
    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) {
            instance = new MenuPanel();
        } return instance;
    }

    public void init() {
        if(newGameButton == null) {
            throw new IllegalArgumentException("New game button is null");
        } if(optionsButton == null) {
            throw new IllegalArgumentException("Options button is null");
        } if(scoreButton == null) {
            throw new IllegalArgumentException("Score button is null");
        } if(exitButton == null)  {
            throw new IllegalArgumentException("Exit button is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        // GRID BAG LAYOUT SETTINGS
        GridBagConstraints gbc = new GridBagConstraints();

        // NEW GAME BUTTON
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(0,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(newGameButton, gbc);

        // SCORE BUTTON
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(scoreButton, gbc);

        // OPTIONS BUTTON
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(optionsButton, gbc);

        // EXIT BUTTON
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,0,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(exitButton, gbc);
    }

    public void setNewGameButton(AbstractButton newGameButton) {
        this.newGameButton = newGameButton;
    }

    public void setOptionsButton(AbstractButton optionsButton) {
        this.optionsButton = optionsButton;
    }

    public void setScoreButton(AbstractButton scoreButton) {
        this.scoreButton = scoreButton;
    }

    public void setExitButton(AbstractButton exitButton) {
        this.exitButton = exitButton;
    }

    public AbstractButton getNewGameButton() {
        return newGameButton;
    }

    public AbstractButton getOptionsButton() {
        return optionsButton;
    }

    public AbstractButton getScoreButton() {
        return scoreButton;
    }

    public AbstractButton getExitButton() {
        return exitButton;
    }

}

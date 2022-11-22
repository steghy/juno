package juno.view.pages.newgame.singleplayer.difficulty.menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel
        extends JPanel {

    private AbstractButton easyButton;
    private AbstractButton mediumButton;
    private AbstractButton hardButton;
    private AbstractButton backButton;

    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) instance = new MenuPanel();
        return instance;
    }

    public void init() {
        if(easyButton == null) {
            throw new IllegalArgumentException("Easy button is null");
        } if(mediumButton == null) {
            throw new IllegalArgumentException("Medium button is null");
        } if(hardButton == null) {
            throw new IllegalArgumentException("Hard button is null");
        } if(backButton == null) {
            throw new IllegalArgumentException("Back button is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // EASY BUTTON
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.insets = new Insets(25,0,0,25);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(easyButton, gbc);

        // MEDIUM BUTTON
        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.insets = new Insets(0,0,0,25);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(mediumButton, gbc);

        // HARD BUTTON
        gbc.gridx = 2;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.insets = new Insets(0,0,0,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(hardButton, gbc);

        // BACK BUTTON
        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.insets = new Insets(0,0,0,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(backButton, gbc);
    }

    public void setEasyButton(AbstractButton easyButton) {
        this.easyButton = easyButton;
    }

    public void setMedium(AbstractButton mediumButton) {
        this.mediumButton = mediumButton;
    }

    public void setHardButton(AbstractButton hardButton) {
        this.hardButton = hardButton;
    }

    public void setBackButton(AbstractButton backButton) {
        this.backButton = backButton;
    }

    public AbstractButton getBackButton() {
        return backButton;
    }
}
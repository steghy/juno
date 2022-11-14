package juno.view.pages.welcolme.registration.menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private AbstractButton toggleButtonMusic;
    private AbstractButton toggleButtonFullScreen;
    private AbstractButton backButton;
    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) {
            instance = new MenuPanel();
        } return instance;
    }

    public void init() {
        if(toggleButtonMusic == null) {
            throw new IllegalArgumentException("Toggle button music is null");
        } if(toggleButtonFullScreen == null) {
            throw new IllegalArgumentException("Toggle button full screen is null");
        } if(backButton == null) {
            throw new IllegalArgumentException("Back button is null");
        }
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // TOGGLE BUTTON MUSIC
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(0,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(toggleButtonMusic, gbc);

        // TOGGLE BUTTON FULL SCREEN
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(toggleButtonFullScreen, gbc);

        // BACK BUTTON
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(backButton, gbc);
    }

    public void setToggleButtonMusic(AbstractButton toggleButtonMusic) {
        this.toggleButtonMusic = toggleButtonMusic;
    }

    public void setToggleButtonFullScreen(AbstractButton toggleButtonFullScreen) {
        this.toggleButtonFullScreen = toggleButtonFullScreen;
    }

    public void setBackButton(AbstractButton backButton) {
        this.backButton = backButton;
    }

    public AbstractButton getToggleButtonMusic() {
        return toggleButtonMusic;
    }

    public AbstractButton getToggleButtonFullScreen() {
        return toggleButtonFullScreen;
    }

    public AbstractButton getBackButton() {
        return backButton;
    }
}

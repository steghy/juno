package juno.view.pages.newgame.menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel{

    private AbstractButton singlePlayer;
    private AbstractButton multiPlayer;
    private AbstractButton backButton;

    private static MenuPanel instance;
    
    private MenuPanel() {}
    
    public static MenuPanel getInstance() {
        if(instance == null) {
            instance = new MenuPanel();
        } return instance;
    }
    
    public void init() {
        if(singlePlayer == null) {
            throw new IllegalArgumentException("Single player is null");
        } if(multiPlayer == null) {
            throw new IllegalArgumentException("Multiplayer is null");
        } if(backButton == null) {
            throw new IllegalArgumentException("Back button is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // SINGLE PLAYER BUTTON
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(5,0,5,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(singlePlayer, gbc);

        // MULTIPLAYER BUTTON
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(5,0,5,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(multiPlayer, gbc);

        // BACK BUTTON
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(5,0,5,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(backButton, gbc);
    }
    
    public void setSinglePlayer(AbstractButton singlePlayer) {
        this.singlePlayer = singlePlayer;
    }

    public void setMultiPlayer(AbstractButton multiPlayer) {
        this.multiPlayer = multiPlayer;
    }

    public void setBackButton(AbstractButton backButton) {
        this.backButton = backButton;
    }

    public AbstractButton getSinglePlayer() {
        return singlePlayer;
    }

    public AbstractButton getMultiPlayer() {
        return multiPlayer;
    }

    public AbstractButton getBackButton() {
        return backButton;
    }
}

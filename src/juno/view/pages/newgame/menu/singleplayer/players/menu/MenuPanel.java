package juno.view.pages.newgame.menu.singleplayer.players.menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private AbstractButton twoPlayers;
    private AbstractButton threePlayers;
    private AbstractButton fourPlayers;
    private AbstractButton backButton;

    private static MenuPanel instance;

    private MenuPanel() {
    }

    public static MenuPanel getInstance() {
        if (instance == null) {
            instance = new MenuPanel();
        }
        return instance;
    }

    public void init() {
        if(twoPlayers == null) {
            throw new IllegalArgumentException("Two players button is null");
        } if(threePlayers == null) {
            throw new IllegalArgumentException("Three players button is null");
        } if(fourPlayers == null) {
            throw new IllegalArgumentException("Four players button is null");
        } if(backButton == null) {
            throw new IllegalArgumentException("Back button is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // TWO PLAYERS BUTTON
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0, 0, 0, 25);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(twoPlayers, gbc);

        // THREE PLAYERS
        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0, 0, 0, 25);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(threePlayers, gbc);

        // FOUR PLAYERS BUTTON
        gbc.gridx = 2;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0, 0, 0, 0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(fourPlayers, gbc);

        // BACK BUTTOn
        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0, 0, 0, 0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(backButton, gbc);
    }

    public void setTwoPlayers(AbstractButton twoPlayers) {
        this.twoPlayers = twoPlayers;
    }

    public void setThreePlayers(AbstractButton threePlayers) {
        this.threePlayers = threePlayers;
    }

    public void setFourPlayers(AbstractButton fourPlayers) {
        this.fourPlayers = fourPlayers;
    }

    public void setBackButton(AbstractButton backButton) {
        this.backButton = backButton;
    }

    public AbstractButton getTwoPlayers() {
        return twoPlayers;
    }

    public AbstractButton getThreePlayers() {
        return threePlayers;
    }

    public AbstractButton getFourPlayers() {
        return fourPlayers;
    }

    public AbstractButton getBackButton() {
        return backButton;
    }
}

package juno.view.pages.newgame.menu.singleplayer.menu.playersNumber;

import javax.swing.*;
import java.awt.*;

public class PlayersNumberPanel extends JPanel {

    private AbstractButton twoPlayers;
    private AbstractButton threePlayers;
    private AbstractButton fourPlayers;

    private static PlayersNumberPanel instance;
    
    private PlayersNumberPanel() {}

    public static PlayersNumberPanel getInstance() {
        if(instance == null) {
            instance = new PlayersNumberPanel();
        } return instance;
    }

    public void init() {
        if(twoPlayers == null) {
            throw new IllegalArgumentException("Two players button is null");
        } if(threePlayers == null) {
            throw new IllegalArgumentException("Three players button is null");
        } if(fourPlayers == null) {
            throw new IllegalArgumentException("Four players button is null");
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

        gbc.insets = new Insets(0,0,0,25);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(twoPlayers, gbc);

        // THREE PLAYERS
        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,0,25);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(threePlayers, gbc);

        // FOUR PLAYERS BUTTON
        gbc.gridx = 2;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,0,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(fourPlayers, gbc);
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

    public AbstractButton getTwoPlayers() {
        return twoPlayers;
    }

    public AbstractButton getThreePlayers() {
        return threePlayers;
    }

    public AbstractButton getFourPlayers() {
        return fourPlayers;
    }
}

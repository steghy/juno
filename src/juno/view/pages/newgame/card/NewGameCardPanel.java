package juno.view.pages.newgame.card;

import javax.swing.*;
import java.awt.*;

public class NewGameCardPanel extends JPanel {

    public static final String NEW_GAME_PANEL = "New game panel";
    public static final String SINGLE_PLAYER_PANEL = "Single player panel";
    public static final String MULTIPLAYER_PANEL = "Multiplayer panel";
    private JPanel newGamePanel;
    private JPanel singlePlayerPanel;
    private JPanel multiplayerPanel;
    private static NewGameCardPanel instance;

    private NewGameCardPanel() {}

    public static NewGameCardPanel getInstance() {
        if(instance == null) {
            instance = new NewGameCardPanel();
        } return instance;
    }

    public void init() {
        if(newGamePanel == null) {
            throw new IllegalArgumentException("New game panel is null");
        } if(singlePlayerPanel == null) {
            throw new IllegalArgumentException("Single player panel is null");
        } if(multiplayerPanel == null) {
            throw new IllegalArgumentException("Multiplayer panel is null");
        }

        setOpaque(false);
        setLayout(new CardLayout());
        add(newGamePanel, NEW_GAME_PANEL);
        add(singlePlayerPanel, SINGLE_PLAYER_PANEL);
        add(multiplayerPanel, MULTIPLAYER_PANEL);
    }

    public void setNewGamePanel(JPanel newGamePanel) {
        this.newGamePanel = newGamePanel;
    }

    public void setSinglePlayerPanel(JPanel singlePlayerPanel) {
        this.singlePlayerPanel = singlePlayerPanel;
    }

    public void setMultiplayerPanel(JPanel multiplayerPanel) {
        this.multiplayerPanel = multiplayerPanel;
    }

    public JPanel getNewGamePanel() {
        return newGamePanel;
    }

    public JPanel getSinglePlayerPanel() {
        return singlePlayerPanel;
    }

    public JPanel getMultiplayerPanel() {
        return multiplayerPanel;
    }
}

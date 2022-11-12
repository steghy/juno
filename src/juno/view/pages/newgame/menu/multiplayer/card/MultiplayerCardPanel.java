package juno.view.pages.newgame.menu.multiplayer.card;

import javax.swing.*;
import java.awt.*;

public class MultiplayerCardPanel extends JPanel {

    public static final String UNAVAILABLE_SERVICE_PANEL = "Unavailable service panel";
    public static final String MULTIPLAYER_PANEL = "Multiplayer panel";
    private JPanel multiplayerPanel;
    private JPanel unavailableServicePanel;
    private static MultiplayerCardPanel instance;

    private MultiplayerCardPanel() {}

    public static MultiplayerCardPanel getInstance() {
        if(instance == null){
            instance = new MultiplayerCardPanel();
        } return instance;
    }

    public void init() {
        if(unavailableServicePanel == null) {
            throw new IllegalArgumentException("Unavailable service panel is null");
        } if(multiplayerPanel == null) {
            throw new IllegalArgumentException("Multiplayer panel is null");
        }

        setOpaque(false);
        setLayout(new CardLayout());
        add(unavailableServicePanel, UNAVAILABLE_SERVICE_PANEL);
        add(multiplayerPanel, MULTIPLAYER_PANEL);
    }

    public void setMultiplayerPanel(JPanel multiplayerPanel) {
        this.multiplayerPanel = multiplayerPanel;
    }

    public void setUnavailableServicePanel(JPanel unavailableServicePanel) {
        this.unavailableServicePanel = unavailableServicePanel;
    }

    public JPanel getMultiplayerPanel() {
        return multiplayerPanel;
    }

    public JPanel getUnavailableServicePanel() {
        return unavailableServicePanel;
    }
}
package juno.view.pages.newGamePanel.multiplayer;

import javax.swing.*;
import java.awt.*;

public class MultiplayerCardPanel extends JPanel {

    public static final String UNAVAILABLE_SERVICE = "Unavailable service";
    public static final String MULTIPLAYER = "Multiplayer";
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
        add(multiplayerPanel, MULTIPLAYER);
        add(unavailableServicePanel, UNAVAILABLE_SERVICE);
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
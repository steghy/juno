package juno.view.pages.newgame.menu.multiplayer.card;

import javax.swing.*;
import java.awt.*;

public class MultiplayerCardPanel extends JPanel {

    public static final String UNAVAILABLE_SERVICE_PANEL = "Unavailable service panel";
    public static final String AVAILABLE_SERVICE_PANEL = "Available service panel";
    private JPanel availableServicePanel;
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
        } if(availableServicePanel == null) {
            throw new IllegalArgumentException("Available service panel is null");
        }

        setOpaque(false);
        setLayout(new CardLayout());
        add(unavailableServicePanel, UNAVAILABLE_SERVICE_PANEL);
        add(availableServicePanel, AVAILABLE_SERVICE_PANEL);
    }

    public void setAvailableServicePanel(JPanel availableServicePanel) {
        this.availableServicePanel = availableServicePanel;
    }

    public void setUnavailableServicePanel(JPanel unavailableServicePanel) {
        this.unavailableServicePanel = unavailableServicePanel;
    }

    public JPanel getAvailableServicePanel() {
        return availableServicePanel;
    }

    public JPanel getUnavailableServicePanel() {
        return unavailableServicePanel;
    }
}
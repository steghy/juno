package juno.view.pages.newgame.multiplayer.card;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MultiplayerCardPanel
        extends JPanel {

    public static final String UNAVAILABLE_SERVICE_PANEL = "Unavailable service panel";
    public static final String AVAILABLE_SERVICE_PANEL = "Available service panel";
    private JPanel availableServicePanel;
    private JPanel unavailableServicePanel;
    private static MultiplayerCardPanel instance;

    private MultiplayerCardPanel() {}

    public static MultiplayerCardPanel getInstance() {
        if(instance == null) instance = new MultiplayerCardPanel();
        return instance;
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

    public void setAvailableServicePanel(@NotNull JPanel availableServicePanel) {
        this.availableServicePanel = availableServicePanel;
    }

    public void setUnavailableServicePanel(@NotNull JPanel unavailableServicePanel) {
        this.unavailableServicePanel = unavailableServicePanel;
    }
}
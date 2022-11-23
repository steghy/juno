package juno.view.pages.newgame.multiplayer.unavailable.menu;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MenuPanel
        extends JPanel{

    private JLabel unavailableServiceLabel;
    private AbstractButton backButton;

    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) instance = new MenuPanel();
        return instance;
    }

    public void init() {
        if (unavailableServiceLabel == null) {
            throw new IllegalArgumentException("Unavailable service label is null");
        } if (backButton == null) {
            throw new IllegalArgumentException("Back button is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // UNAVAILABLE SERVICE LABEL
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        add(unavailableServiceLabel, gbc);

        // BACK BUTTON
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        add(backButton, gbc);
    }

    public void setUnavailableServiceLabel(@NotNull JLabel unavailableServiceLabel) {
        this.unavailableServiceLabel = unavailableServiceLabel;
    }

    public void setBackButton(@NotNull AbstractButton backButton) {
        this.backButton = backButton;
    }
}
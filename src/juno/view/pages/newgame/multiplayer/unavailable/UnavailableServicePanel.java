package juno.view.pages.newgame.multiplayer.unavailable;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class UnavailableServicePanel
        extends JPanel {

    private JPanel titlePanel;
    private JPanel menuPanel;

    private static UnavailableServicePanel instance;

    private UnavailableServicePanel() {}

    public static UnavailableServicePanel getInstance() {
        if(instance == null) instance = new UnavailableServicePanel();
        return instance;
    }

    public void init() {
        if (titlePanel == null) {
            throw new IllegalArgumentException("Title panel is null");
        } if (menuPanel == null) {
            throw new IllegalArgumentException("Menu panel is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // TITLE PANEL
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        add(titlePanel, gbc);

        // MENU PANEL
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        add(menuPanel, gbc);
    }

    public void setTitlePanel(@NotNull JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }

    public void setMenuPanel(@NotNull JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }
}
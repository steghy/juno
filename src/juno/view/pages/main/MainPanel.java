package juno.view.pages.main;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MainPanel
        extends JPanel {

    private JPanel menuPanel;
    private JPanel titlePanel;
    private static MainPanel instance;

    private MainPanel() {}

    public static MainPanel getInstance() {
        if(instance == null) instance = new MainPanel();
        return instance;
    }

    public void init() {
        if(menuPanel == null) {
            throw new IllegalArgumentException("Menu panel is null");
        } if(titlePanel == null) {
            throw new IllegalArgumentException("Title panel is null");
        }

        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // TITLE PANEL
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,30,0);

        this.add(titlePanel, gbc);

        // MENU PANEL
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,0,0);

        this.add(menuPanel, gbc);

    }

    public void setMenuPanel(@NotNull JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    public void setTitlePanel(@NotNull JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }
}
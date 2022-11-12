package juno.view.pages.newgame.menu.singleplayer;

import javax.swing.*;
import java.awt.*;

public class SinglePlayerPanel extends JPanel {

    private JPanel titlePanel;
    private JPanel menuPanel;
    private static SinglePlayerPanel instance;

    private SinglePlayerPanel() {}

    public static SinglePlayerPanel getInstance() {
        if(instance == null) {
            instance = new SinglePlayerPanel();
        } return instance;
    }

    public void init() {
        if(titlePanel == null) {
            throw new IllegalArgumentException("Title panel is null");
        } if(menuPanel == null) {
            throw new IllegalArgumentException("Menu panel is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // TITLE PANEL
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(0,0,20,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        add(titlePanel, gbc);

        // MENU PANEL
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(0,0,30,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        add(menuPanel, gbc);
    }

    public void setTitlePanel(JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }

    public void setMenuPanel(JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    public JPanel getTitlePanel() {
        return titlePanel;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }
}
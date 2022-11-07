package juno.view.example2.panel;

import juno.view.example2.panel.logoPanel.LogoPanel;
import juno.view.example2.panel.menuPanel.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public Panel() {
        init();
    }

    private void init() {
        // DEFAULT SETTINGS
        this.setOpaque(false);
        this.setLayout(new BorderLayout());

        // COMPONENTS
        Background background = new Background();
        LogoPanel logoPanel = new LogoPanel();
        MenuPanel menuPanel = new MenuPanel();

        background.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // LOGO PANEL
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.3;
        gbc.weighty = 0.3;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.fill = GridBagConstraints.BOTH;

        background.add(logoPanel, gbc);

        // MENU PANEL
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.35;
        gbc.weighty = 0.35;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.BOTH;

        background.add(menuPanel, gbc);

        this.add(background, BorderLayout.CENTER);
    }
}
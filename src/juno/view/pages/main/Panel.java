package juno.view.pages.main;

import juno.view.pages.backgrounds.Background;
import juno.view.pages.main.logoPanel.LogoPanel;
import juno.view.pages.main.menuPanel.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private static Panel instance;

    private Panel() {
        init();
    }

    public static Panel getInstance() {
        if(instance == null) {
            instance = new Panel();
        } return instance;
    }

    private void init() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());

        // COMPONENTS
        Background background = Background.getInstance();
        LogoPanel logoPanel = LogoPanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();

        background.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // LOGO PANEL
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.VERTICAL;

        background.add(logoPanel, gbc);

        // MENU PANEL
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.35;
        gbc.weighty = 0.35;

        gbc.anchor = GridBagConstraints.CENTER;

        // gbc.fill = GridBagConstraints.BOTH;

        background.add(menuPanel, gbc);

        this.add(background, BorderLayout.CENTER);
    }
}
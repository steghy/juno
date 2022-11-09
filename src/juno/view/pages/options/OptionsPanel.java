package juno.view.pages.options;

import juno.view.logo.LogoPanel;
import juno.view.pages.options.menuPanel.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {

    private static OptionsPanel instance;

    private OptionsPanel() {
        init();
    }

    public static OptionsPanel getInstance() {
        if(instance == null) {
            instance = new OptionsPanel();
        } return instance;
    }

    private void init() {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        // COMPONENTS
        LogoPanel logoPanel = new LogoPanel();
        MenuPanel menuPanel = MenuPanel.getInstance();

        GridBagConstraints gbc = new GridBagConstraints();

        // LOGO PANEL
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        this.add(logoPanel, gbc);

        // MENU PANEL
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.35;
        gbc.weighty = 0.35;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        this.add(menuPanel, gbc);
    }

}

package juno.view.pages.mainPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private JPanel menuPanel;
    private JPanel logoPanel;
    private static MainPanel instance;

    private MainPanel() {}

    public static MainPanel getInstance() {
        if(instance == null) {
            instance = new MainPanel();
        } return instance;
    }

    public void init() {
        if(menuPanel == null) {
            throw new IllegalArgumentException("Menu panel is null");
        } if(logoPanel == null) {
            throw new IllegalArgumentException("Logo panel is null");
        }

        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

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

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        this.add(menuPanel, gbc);

    }

    public void setMenuPanel(JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    public void setLogoPanel(JPanel logoPanel) {
        this.logoPanel = logoPanel;
    }
}
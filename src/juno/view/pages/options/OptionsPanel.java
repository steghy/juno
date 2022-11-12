package juno.view.pages.options;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {

    private JPanel titlePanel;
    private JPanel menuPanel;
    private static OptionsPanel instance;

    private OptionsPanel() {}

    public static OptionsPanel getInstance() {
        if(instance == null) {
            instance = new OptionsPanel();
        } return instance;
    }

    public void init() {
        if(titlePanel == null) {
            throw new IllegalArgumentException("Title panel is null");
        } if(menuPanel == null) {
            throw new IllegalArgumentException("Menu panel is null");
        }
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // TITLE PANEL
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.10;
        gbc.weighty = 0.35;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        this.add(titlePanel, gbc);

        // MENU PANEL
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.35;
        gbc.weighty = 0.35;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        this.add(menuPanel, gbc);
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
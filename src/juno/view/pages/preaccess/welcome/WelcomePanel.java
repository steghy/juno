package juno.view.pages.preaccess.welcome;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {

    private JPanel titlePanel;
    private JPanel menuPanel;
    private static WelcomePanel instance;

    private WelcomePanel() {}

    public static WelcomePanel getInstance() {
        if(instance == null) {
            instance = new WelcomePanel();
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

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(titlePanel, gbc);

        // MENU PANEL
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,5,0);

        this.add(menuPanel, gbc);
    }

    public void setTitlePanel(@NotNull JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }

    public void setMenuPanel(@NotNull JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    public JPanel getTitlePanel() {
        return titlePanel;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }
}

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

        setOpaque(true);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
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

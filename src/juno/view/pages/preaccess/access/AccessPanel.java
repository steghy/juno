package juno.view.pages.preaccess.access;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class AccessPanel extends JPanel {

    private JPanel titlePanel;
    private JPanel menuPanel;
    private static AccessPanel instance;

    private AccessPanel() {}

    public static AccessPanel getInstance() {
        if(instance == null) {
            instance = new AccessPanel();
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

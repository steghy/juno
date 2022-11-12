package juno.view.pages.newGamePanel.singleplayer;

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
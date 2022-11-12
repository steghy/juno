package juno.view.pages.newgame.menu.singleplayer.card;

import javax.swing.*;
import java.awt.*;

public class SinglePlayerCardPanel extends JPanel {

    public static final String MAIN_PANEL = "Main panel";
    public static final String MODE_PANEL = "Mode panel";

    private JPanel mainPanel;
    private JPanel modePanel;

    private static SinglePlayerCardPanel instance;

    public static SinglePlayerCardPanel getInstance() {
        if(instance == null) {
            instance = new SinglePlayerCardPanel();
        } return instance;
    }

    public void init() {
        if(mainPanel == null) {
            throw new IllegalArgumentException("Main panel is null");
        } if(modePanel == null) {
            throw new IllegalArgumentException("Mode panel is null");
        }

        setOpaque(false);
        setLayout(new CardLayout());
        add(mainPanel, MAIN_PANEL);
        add(modePanel, MODE_PANEL);
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setModePanel(JPanel modePanel) {
        this.modePanel = modePanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getModePanel() {
        return modePanel;
    }
}
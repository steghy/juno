package juno.view.frame;

import juno.view.pages.main.MainPanel;
import juno.view.pages.options.OptionsPanel;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {

    private static CardPanel instance;

    private CardPanel() {
        init();
    }

    public static CardPanel getInstance() {
        if(instance == null) {
            instance = new CardPanel();
        } return instance;
    }

    private void init() {
        this.setLayout(new CardLayout());
        this.setOpaque(false);
        MainPanel mainPanel = MainPanel.getInstance();
        // OptionsPanel optionsPanel = OptionsPanel.getInstance();
        this.add(mainPanel, "1");
        // this.add(optionsPanel, "2");
    }
}
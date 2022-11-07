package juno.view.example.panel.center.center;

import juno.view.example.panel.center.center.menu.buttons.ButtonsPanel;
import juno.view.util.LabelConfigurator;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private static MenuPanel instance;

    private MenuPanel() {
        init();
    }

    public static MenuPanel getInstance() {
        if (instance == null) {
            instance = new MenuPanel();
        }
        return instance;
    }

    public void init() {

        this.setOpaque(false);
        this.setLayout(new BorderLayout());

        JLabel westLabel = new JLabel();
        JLabel eastLabel = new JLabel();
        JLabel southLabel = new JLabel();
        JLabel northLabel = new JLabel();
        ButtonsPanel buttonsPanel = ButtonsPanel.getInstance();

        LabelConfigurator.configure(southLabel, 0, 300);
        LabelConfigurator.configure(northLabel, 0,0);
        LabelConfigurator.configure(westLabel, 300, 0);
        LabelConfigurator.configure(eastLabel, 300, 0);

        this.add(northLabel, BorderLayout.NORTH);
        this.add(southLabel, BorderLayout.SOUTH);
        this.add(westLabel, BorderLayout.WEST);
        this.add(eastLabel, BorderLayout.EAST);
        this.add(buttonsPanel, BorderLayout.CENTER);
    }
}

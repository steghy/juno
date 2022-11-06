package juno.view.example.panel.center.center;

import juno.view.example.panel.center.center.menu.buttons.ButtonsPanel;
import juno.view.example.panel.center.center.menu.buttons.ButtonsPanelConfigurator;
import juno.view.util.LabelConfigurator;

import javax.swing.*;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        MenuPanel menuPanel = MenuPanel.getInstance();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new BorderLayout());

        JLabel westLabel = new JLabel();
        JLabel eastLabel = new JLabel();
        JLabel southLabel = new JLabel();
        JLabel northLabel = new JLabel();
        ButtonsPanel buttonsPanel = ButtonsPanel.getInstance();

        ButtonsPanelConfigurator.configure();

        LabelConfigurator.configure(southLabel, 0, 0);
        LabelConfigurator.configure(northLabel, 0,0);
        LabelConfigurator.configure(westLabel, 0, 0);
        LabelConfigurator.configure(eastLabel, 0, 0);

        menuPanel.add(northLabel, BorderLayout.NORTH);
        menuPanel.add(southLabel, BorderLayout.SOUTH);
        menuPanel.add(westLabel, BorderLayout.WEST);
        menuPanel.add(eastLabel, BorderLayout.EAST);
        menuPanel.add(buttonsPanel, BorderLayout.CENTER);
    }
}
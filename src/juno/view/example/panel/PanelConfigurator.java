package juno.view.example.panel;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.example.panel.center.CenterPanel;
import juno.view.example.panel.center.CenterPanelConfigurator;

import juno.view.example.panel.east.EastPanel;
import juno.view.example.panel.east.EastPanelConfigurator;

import juno.view.example.panel.north.NorthPanel;
import juno.view.example.panel.north.NorthPanelConfigurator;

import juno.view.example.panel.south.SouthPanel;
import juno.view.example.panel.south.SouthPanelConfigurator;

import juno.view.example.panel.west.WestPanel;
import juno.view.example.panel.west.WestPanelConfigurator;

import javax.swing.*;

public class PanelConfigurator {

    private PanelConfigurator() {}

    public static void configure() {
        Panel panel = Panel.getInstance();

        JLabel background = new JLabel();
        NorthPanel northPanel = NorthPanel.getInstance();
        CenterPanel centerPanel = CenterPanel.getInstance();
        SouthPanel southPanel = SouthPanel.getInstance();
        WestPanel westPanel = WestPanel.getInstance();
        EastPanel eastPanel = EastPanel.getInstance();

        String backgroundImage = PathGenerator.generate(Paths.BACKGROUNDS.getPath(), "background.gif");
        background.setIcon(new ImageIcon(backgroundImage));

        NorthPanelConfigurator.configure();
        CenterPanelConfigurator.configure();
        SouthPanelConfigurator.configure();
        WestPanelConfigurator.configure();
        EastPanelConfigurator.configure();

        panel.setBackground(background);
        panel.setNorthComponent(northPanel);
        panel.setCenterComponent(centerPanel);
        panel.setSouthComponent(southPanel);
        panel.setWestComponent(westPanel);
        panel.setEastComponent(eastPanel);

        panel.init();
    }
}

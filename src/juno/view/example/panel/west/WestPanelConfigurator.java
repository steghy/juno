package juno.view.example.panel.west;

import javax.swing.*;
import java.awt.*;

public class WestPanelConfigurator {

    private WestPanelConfigurator() {}

    public static void configure() {
        WestPanel westPanel = WestPanel.getInstance();
        westPanel.setOpaque(false);

        JLabel westLabel = new JLabel();
        westLabel.setOpaque(false);
        westLabel.setPreferredSize(new Dimension(0,0));


        westPanel.add(westLabel);
    }
}

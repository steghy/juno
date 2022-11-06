package juno.view.example.panel.east;

import juno.view.util.ComponentResizer;

import javax.swing.JLabel;
import java.awt.*;

public class EastPanelConfigurator {

    private EastPanelConfigurator() {}

    public static void configure() {
        EastPanel eastPanel = EastPanel.getInstance();
        eastPanel.setOpaque(false);

        JLabel eastLabel = new JLabel();
        eastLabel.setOpaque(false);
        eastLabel.setPreferredSize(new Dimension(0,0));

        eastPanel.add(eastLabel);
    }
}

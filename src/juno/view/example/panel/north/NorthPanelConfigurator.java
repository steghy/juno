package juno.view.example.panel.north;

import javax.swing.JLabel;
import java.awt.*;

public class NorthPanelConfigurator {

    private NorthPanelConfigurator() {}

    public static void configure() {
        NorthPanel northPanel = NorthPanel.getInstance();
        northPanel.setOpaque(false);

        JLabel northLabel = new JLabel();
        northLabel.setOpaque(false);
        northLabel.setPreferredSize(new Dimension(0, 0));

        northPanel.add(northLabel);
    }
}

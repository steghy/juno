package juno.view.util;

import javax.swing.*;
import java.awt.*;

public class PanelConfigurator {

    private PanelConfigurator() {}

    public static void configure(JPanel panel, Dimension dimension) {

        panel.setOpaque(false);

        // DIMENSION
        panel.setSize(dimension);
        panel.setPreferredSize(dimension);
        panel.setMinimumSize(dimension);
        panel.setMaximumSize(dimension);

    }
}

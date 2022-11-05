package juno.view.util;

import javax.swing.*;
import java.awt.*;

public class LabelConfigurator {

    private LabelConfigurator() {
    }

    public static void configure(JLabel label, int width, int height) {
        label.setOpaque(false);

        // DIMENSION
        Dimension dimension = new Dimension(width, height);
        label.setSize(dimension);
        label.setPreferredSize(dimension);
        label.setMinimumSize(dimension);
        label.setMaximumSize(dimension);
    }

    public static void configure(JLabel label, Dimension dimension) {
        label.setOpaque(false);

        // DIMENSION
        label.setSize(dimension);
        label.setPreferredSize(dimension);
        label.setMinimumSize(dimension);
        label.setMaximumSize(dimension);
    }
}
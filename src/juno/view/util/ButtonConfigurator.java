package juno.view.util;

import javax.swing.*;
import java.awt.*;

public class ButtonConfigurator extends Button {

    private ButtonConfigurator() {}

    public static void configure(AbstractButton button, int width, int height) {
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setFocusPainted(false);

        // DIMENSION
        Dimension dimension = new Dimension(width, height);
        button.setSize(dimension);
        button.setPreferredSize(dimension);
        button.setMinimumSize(dimension);
        button.setMaximumSize(dimension);
    }

    public static void configure(AbstractButton button, Dimension dimension) {
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setFocusPainted(false);

        // DIMENSION
        button.setSize(dimension);
        button.setPreferredSize(dimension);
        button.setMinimumSize(dimension);
        button.setMaximumSize(dimension);
    }
}
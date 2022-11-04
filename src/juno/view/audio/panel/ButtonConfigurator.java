package juno.view.audio.panel;

import javax.swing.*;
import java.awt.*;

public class ButtonConfigurator extends Button {

    private ButtonConfigurator() {}

    public static void configure(AbstractButton button) {
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setFocusPainted(false);

        // DIMENSION
        Dimension dimension = new Dimension(50, 50);
        button.setSize(dimension);
        button.setPreferredSize(dimension);
        button.setMinimumSize(dimension);
        button.setMaximumSize(dimension);
    }
}
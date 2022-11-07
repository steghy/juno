package juno.view.example2.panel.menuPanel;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;

public class OptionsButton extends JButton {

    public OptionsButton() {
        init();
    }

    private void init() {
        // DEFAULT SETTINGS
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);

        // DIMENSION SETTINGS
        Dimension dimension = new Dimension(150, 50);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);

        // IMAGE SETTINGS
        String imageNF = PathGenerator.generate(Paths.BUTTONS.getPath(), "options-not-focus.png");
        String imageF = PathGenerator.generate(Paths.BUTTONS.getPath(), "options-focus.png");
        this.setIcon(new ImageIcon(ImageResizer.resize(this, imageNF)));
        this.setRolloverIcon(new ImageIcon(ImageResizer.resize(this, imageF)));

        // ACTION LISTENER
    }
}

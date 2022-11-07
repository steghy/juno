package juno.view.logo;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;

public class Logo extends JButton {

    public Logo() {
        init();
    }

    private void init() {
        // DEFAULT SETTINGS
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setName("logo");

        // ALIGNMENT
        this.setAlignmentX(JButton.CENTER_ALIGNMENT);
        this.setAlignmentY(JButton.CENTER_ALIGNMENT);
        this.setHorizontalAlignment(JButton.CENTER);
        this.setVerticalAlignment(JButton.CENTER);

        // DIMENSION
        Dimension dimension = new Dimension(640, 449);
        this.setPreferredSize(dimension);

    }

    public void setPreferredSize(Dimension dimension) {
        if(dimension == null) {
            throw new IllegalArgumentException("Invalid usage, input is null");
        } if(dimension.getWidth() == 0 || dimension.getHeight() == 0) {
            throw new IllegalArgumentException(
                    "Invalid usage for dimension width: " + dimension.getWidth() +
                            " and height: " + dimension.getHeight());
        } else {
            super.setPreferredSize(dimension);
            super.setSize(dimension);
            super.setMinimumSize(dimension);
            super.setMaximumSize(dimension);
            // LOGO IMAGES
            String logoImageNF = PathGenerator.generate(Paths.LOGOS.getPath(), "logo-3.png");
            String logoImageF = PathGenerator.generate(Paths.LOGOS.getPath(), "logo-3.png");
            this.setIcon(new ImageIcon(ImageResizer.resize(this, logoImageNF)));
            this.setRolloverIcon(new ImageIcon(ImageResizer.resize(this, logoImageF)));
        }
    }
}

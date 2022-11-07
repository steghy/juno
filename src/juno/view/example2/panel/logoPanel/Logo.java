package juno.view.example2.panel.logoPanel;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.util.ImageResizer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Logo extends JButton {

    public Logo() {
        init();
    }

    private void init() {
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);

        // ALIGNMENT
        this.setAlignmentX(JButton.CENTER_ALIGNMENT);
        this.setAlignmentY(JButton.CENTER_ALIGNMENT);
        this.setHorizontalAlignment(JButton.CENTER);
        this.setVerticalAlignment(JButton.CENTER);

        // DIMENSION
        Dimension dimension = new Dimension(250, 150);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);

        // BORDER
        // Border border = BorderFactory.createTitledBorder("logo");
        // this.setBorder(border);

        // LOGO IMAGES
        String logoImageNF = PathGenerator.generate(Paths.LOGOS.getPath(), "logo-not-focus.png");
        String logoImageF = PathGenerator.generate(Paths.LOGOS.getPath(), "logo-focus.png");
        this.setIcon(new ImageIcon(ImageResizer.resize(this, logoImageNF)));
        this.setRolloverIcon(new ImageIcon(ImageResizer.resize(this, logoImageF)));
    }
}

package juno.view.pages.backgrounds;

import juno.init.Directories;
import juno.model.util.PathGenerator;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;

public class Background extends JLabel {

    public Background() {
        init();
    }

    private void init() {
        this.setOpaque(false);

        // DIMENSION
        Dimension dimension = new Dimension(1920, 1080);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);

        String backgroundImage = PathGenerator.generate(Directories.BACKGROUNDS.getPath(), "background.gif");
        this.setIcon(new ImageIcon(ImageResizer.resize(this, backgroundImage)));
    }
}
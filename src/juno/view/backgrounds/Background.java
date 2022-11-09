package juno.view.backgrounds;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageComponentInitializer;

import javax.swing.*;
import java.awt.*;

public class Background extends JLabel {

    private static Background instance;

    private Background() {
        initialize();
    }

    public static Background getInstance() {
        if(instance == null) {
            instance = new Background();
        } return instance;
    }

    private void initialize() {
        ImageComponentInitializer.initialize(
                this,
                Directories.BACKGROUNDS,
                "background",
                "background.gif",
                new Dimension(1000, 1000),
                Constant.CYAN_LABEL
        );
    }
}
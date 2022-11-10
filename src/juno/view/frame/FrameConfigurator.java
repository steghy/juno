package juno.view.frame;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageComponentInitializer;

import javax.swing.*;

public class FrameConfigurator {

    private FrameConfigurator() {}

    public static void configure() {
        Frame frame = Frame.getInstance();

        JLabel background = new JLabel();
        JPanel cardPanel = CardPanel.getInstance();

        ImageComponentInitializer.initialize(
                background,
                Directories.BACKGROUNDS,
                "Background",
                "background.gif",
                null,
                Constant.THROW_EXCEPTION
        );

        frame.setBackground(background);
        frame.setPanel(cardPanel);
        frame.init();
    }
}

package juno.view.frame;

import juno.init.Directories;
import juno.view.pages.card.TopCardPanel;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.pages.preaccess.card.PreAccessCardPanel;
import juno.view.util.Constant;
import juno.view.util.ImageComponentInitializer;

import javax.swing.*;

public class FrameInitializer {

    private FrameInitializer() {}

    public static void initializer() {
        Frame frame = Frame.getInstance();

        JLabel background = new JLabel();
        JPanel topCardPanel = TopCardPanel.getInstance();

        ImageComponentInitializer.initialize(
                background,
                Directories.BACKGROUNDS,
                true,
                "Background",
                "background.gif",
                null,
                Constant.THROW_EXCEPTION
        );

        frame.setBackground(background);
        frame.setPanel(topCardPanel);
        frame.init();
    }
}

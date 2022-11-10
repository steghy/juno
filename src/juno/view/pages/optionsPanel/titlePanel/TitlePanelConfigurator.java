package juno.view.pages.optionsPanel.titlePanel;

import juno.init.Directories;
import juno.view.util.*;

import javax.swing.*;
import java.awt.*;

public class TitlePanelConfigurator {

    private TitlePanelConfigurator() {}

    public static void configure() {
        TitlePanel titlePanel = TitlePanel.getInstance();

        AbstractButton title = new ImageButton();

        ImageComponentInitializer.initialize(
                title,
                Directories.BUTTONS,
                "Options",
                "options-button.png",
                "options-button-rollover.png",
                new Dimension(600, 300),
                Constant.THROW_EXCEPTION,
                Constant.KEEP_ROLLOVER_IMAGE,
                Constant.KEEP_IMAGE
        );

        // IMAGE RESIZE
        ImageResizer.resize(title, 2.0);

        // SETTING COMPONENTS
        titlePanel.setTitle(title);

        // BORDER
        RoundedBorder border = new RoundedBorder(50, 2, null, Color.white);
        titlePanel.setBorder(border);

        // ACTION LISTENER

        // INITIALIZATION
        titlePanel.init();
    }
}

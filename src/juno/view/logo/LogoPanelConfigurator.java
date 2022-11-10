package juno.view.logo;

import juno.init.Directories;
import juno.view.util.*;

import javax.swing.*;
import java.awt.*;

public class LogoPanelConfigurator {

    private LogoPanelConfigurator() {}

    public static void configure() {
        LogoPanel logoPanel = LogoPanel.getInstance();

        AbstractButton logo = new ImageButton();

        ImageComponentInitializer.initialize(
                logo,
                Directories.BUTTONS,
                "Uno logo",
                "uno-button.png",
                "uno-button-rollover.png",
                new Dimension(300, 300),
                Constant.THROW_EXCEPTION,
                Constant.KEEP_ROLLOVER_IMAGE,
                Constant.KEEP_IMAGE
        );

        // IMAGE RESIZE
        ImageResizer.resize(logo, 2.0);

        // BORDER
        RoundedBorder border = new RoundedBorder(50, 2, null, Color.WHITE);
        logoPanel.setBorder(border);

        // ADDING COMPONENTS
        logoPanel.setLogo(logo);

        // INITIALIZATION
        logoPanel.init();
    }
}

package juno.view.logo;

import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.util.*;

import javax.swing.*;
import java.awt.*;

public class LogoPanelConfigurator {

    private LogoPanelConfigurator() {}

    public static void configure() {
        LogoPanel logoPanel = LogoPanel.getInstance();

        AbstractButton logo = ButtonFactory.createButton(ButtonLibrary.LOGO);

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

package juno.view.pages.main.title;

import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;
import juno.view.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TitlePanelConfigurator {

    private TitlePanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        TitlePanel titlePanel = TitlePanel.getInstance();

        // SUB COMPONENTS
        AbstractButton title = ButtonFactory.createButton(ButtonLibrary.JUNO);

        // RESIZE IMAGE
        ImageResizer.resize(title, 3.0);

        // BORDER
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        titlePanel.setBorder(border);

        // ADDING COMPONENTS
        titlePanel.setLogo(title);

        // INITIALIZATION
        titlePanel.init();
    }
}
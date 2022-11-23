package juno.view.pages.preaccess.welcome.title;

import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TitlePanelConfigurator {

    private TitlePanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        TitlePanel titlePanel = TitlePanel.getInstance();

        // SUB COMPONENTS
        AbstractButton title = ButtonFactory.createButton(ButtonLibrary.WELCOME);

        // RESIZE IMAGE
        ImageResizer.resize(title, 3.0);

        // SETTING COMPONENTS
        titlePanel.setTitle(title);

        // BORDER
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        titlePanel.setBorder(border);

        // INITIALIZATION
        titlePanel.init();
    }
}

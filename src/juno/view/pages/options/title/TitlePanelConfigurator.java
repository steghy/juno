package juno.view.pages.options.title;

import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TitlePanelConfigurator {

    private TitlePanelConfigurator() {}

    public static void configure() {
        TitlePanel titlePanel = TitlePanel.getInstance();

        AbstractButton title = ButtonFactory.createButton(ButtonLibrary.SETTINGS);

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

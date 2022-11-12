package juno.view.pages.optionsPanel.titlePanel;

import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.util.*;

import javax.swing.*;
import java.awt.*;

public class TitlePanelConfigurator {

    private TitlePanelConfigurator() {}

    public static void configure() {
        TitlePanel titlePanel = TitlePanel.getInstance();

        AbstractButton title = ButtonFactory.createButton(ButtonLibrary.SETTINGS);

        ImageResizer.resize(title, 2.0);

        // SETTING COMPONENTS
        titlePanel.setTitle(title);

        // BORDER
        RoundedBorder border = new RoundedBorder(50, 2, null, Color.white);
        titlePanel.setBorder(border);

        // INITIALIZATION
        titlePanel.init();
    }
}

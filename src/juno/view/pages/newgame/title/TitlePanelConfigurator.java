package juno.view.pages.newgame.title;

import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TitlePanelConfigurator {

    private TitlePanelConfigurator() {}

    public static void configure() {

        // COMPONENTS
        TitlePanel titlePanel = TitlePanel.getInstance();

        // SUB-COMPONENTS
        AbstractButton titleButton = ButtonFactory.createButton(ButtonLibrary.NEW_GAME_TITLE);

        // RESIZE IMAGE
        ImageResizer.resize(titleButton, 3.0);

        // BORDER
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        titlePanel.setBorder(border);

        // ADDING COMPONENTS
        titlePanel.setTitle(titleButton);

        // INITIALIZATION
        titlePanel.init();
    }
}

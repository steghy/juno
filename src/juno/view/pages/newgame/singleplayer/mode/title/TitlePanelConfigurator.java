package juno.view.pages.newgame.singleplayer.mode.title;

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
        // MAIN COMPONENT
        TitlePanel titlePanel = TitlePanel.getInstance();

        // SUB-COMPONENTS
        AbstractButton titleButton = ButtonFactory.createButton(ButtonLibrary.MODE);

        // RESIZE IMAGE
        ImageResizer.resize(titleButton, 3.0);

        // BORDER SETTING
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        titlePanel.setBorder(border);

        // ADDING COMPONENTS
        titlePanel.setTitleButton(titleButton);

        // INITIALIZATION
        titlePanel.init();
    }
}

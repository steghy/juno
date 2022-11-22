package juno.view.pages.newgame.singleplayer.difficulty.title;

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
        AbstractButton title = ButtonFactory.createButton(ButtonLibrary.DIFFICULTY);

        // RESIZE IMAGE
        ImageResizer.resize(title, 3.0);

        // BORDER SETTING
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        titlePanel.setBorder(border);

        // ADDING COMPONENTS
        titlePanel.setTitleButton(title);

        // INITIALIZATION
        titlePanel.init();
    }
}
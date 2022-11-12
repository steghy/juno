package juno.view.pages.newgame.menu.singleplayer.title;

import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class TitlePanelConfigurator {

    private TitlePanelConfigurator() {}

    public static void configure() {

        // COMPONENTS
        TitlePanel titlePanel = TitlePanel.getInstance();

        // SUB-COMPONENTS
        AbstractButton title = ButtonFactory.createButton(ButtonLibrary.SINGLE_PLAYER_TITLE);

        // RESIZE IMAGE
        ImageResizer.resize(title, 2.5);

        // BORDER SETTING
        RoundedBorder roundedBorder = new RoundedBorder(50, 2, null, Color.WHITE);
        titlePanel.setBorder(roundedBorder);

        // ADDING COMPONENTS
        titlePanel.setTitle(title);

        // INITIALIZATION
        titlePanel.init();
    }
}

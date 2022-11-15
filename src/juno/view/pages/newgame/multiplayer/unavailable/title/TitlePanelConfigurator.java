package juno.view.pages.newgame.multiplayer.unavailable.title;

import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.util.ImageResizer;

import javax.swing.*;

public class TitlePanelConfigurator {

    private TitlePanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        TitlePanel titlePanel = TitlePanel.getInstance();

        // SUB COMPONENTS
        AbstractButton titleButton = ButtonFactory.createButton(ButtonLibrary.UNAVAILABLE_SERVICE);

        // RESIZE COMPONENT
        ImageResizer.resize(titleButton, 2.0);

        // ADDING COMPONENT
        titlePanel.setTitleButton(titleButton);

        // MAIN COMPONENT INITIALIZATION
        titlePanel.init();
    }
}

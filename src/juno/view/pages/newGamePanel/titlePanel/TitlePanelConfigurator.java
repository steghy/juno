package juno.view.pages.newGamePanel.titlePanel;

import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;

import javax.swing.*;

public class TitlePanelConfigurator {

    private TitlePanelConfigurator() {}

    public static void configure() {

        // COMPONENTS
        TitlePanel titlePanel = TitlePanel.getInstance();

        // SUB-COMPONENTS
        AbstractButton title = ButtonFactory.createButton(ButtonLibrary.NEW_GAME_TITLE);

        // ADDING COMPONENTS
        titlePanel.setTitle(title);

        // INITIALIZATION
        titlePanel.init();
    }
}

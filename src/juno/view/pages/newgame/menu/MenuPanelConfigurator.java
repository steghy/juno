package juno.view.pages.newgame.menu;

import juno.controller.menu.ChangePanelAction;
import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.pages.newgame.card.NewGameCardPanel;
import juno.view.util.ImageResizer;

import javax.swing.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        MenuPanel newGameMenuPanel = MenuPanel.getInstance();

        // SUB-COMPONENTS
        AbstractButton singlePlayer = ButtonFactory.createButton(ButtonLibrary.SINGLE_PLAYER);
        AbstractButton multiPlayer = ButtonFactory.createButton(ButtonLibrary.MULTIPLAYER);
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);

        // RESIZE IMAGES
        ImageResizer.resize(singlePlayer, 2.0);
        ImageResizer.resize(multiPlayer, 2.0);
        ImageResizer.resize(backButton, 2.0);

        // ACTION LISTENERS
        singlePlayer.addActionListener(new ChangePanelAction(NewGameCardPanel.getInstance(), NewGameCardPanel.SINGLE_PLAYER_PANEL));
        multiPlayer.addActionListener(new ChangePanelAction(NewGameCardPanel.getInstance(), NewGameCardPanel.MULTIPLAYER_PANEL));
        backButton.addActionListener(new ChangePanelAction(MainCardPanel.getInstance(), MainCardPanel.MAIN_PANEL));

        // ADDING COMPONENTS
        newGameMenuPanel.setSinglePlayer(singlePlayer);
        newGameMenuPanel.setMultiPlayer(multiPlayer);
        newGameMenuPanel.setBackButton(backButton);

        // INITIALIZATION
        newGameMenuPanel.init();
    }
}

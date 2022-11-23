package juno.view.pages.newgame.menu;

import juno.controller.ChangePanelAction;
import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.pages.newgame.card.NewGameCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

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
        ImageResizer.resize(singlePlayer, 3.0);
        ImageResizer.resize(multiPlayer, 3.0);
        ImageResizer.resize(backButton, 3.0);


        // BORDER
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        newGameMenuPanel.setBorder(border);

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

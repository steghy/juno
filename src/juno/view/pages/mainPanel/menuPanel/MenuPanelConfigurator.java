package juno.view.pages.mainPanel.menuPanel;

import juno.controller.menu.ChangePanelAction;
import juno.controller.menu.ExitAction;
import juno.init.ExitManager;
import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.pages.mainPanel.MainCardPanel;
import juno.view.util.*;

import javax.swing.*;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        MenuPanel menuPanel = MenuPanel.getInstance();

        AbstractButton newGameButton = ButtonFactory.createButton(ButtonLibrary.NEW_GAME);
        AbstractButton optionsButton = ButtonFactory.createButton(ButtonLibrary.OPTIONS);
        AbstractButton scoreButton = ButtonFactory.createButton(ButtonLibrary.SCORE);
        AbstractButton exitButton = ButtonFactory.createButton(ButtonLibrary.EXIT);

        ImageResizer.resize(newGameButton, 2.0);
        ImageResizer.resize(optionsButton, 2.0);
        ImageResizer.resize(scoreButton, 2.0);
        ImageResizer.resize(exitButton, 2.0);

        // ACTION LISTENERS
        newGameButton.addActionListener(new ChangePanelAction(MainCardPanel.getInstance(), MainCardPanel.NEW_GAME_PANEL));
        scoreButton.addActionListener(new ChangePanelAction(MainCardPanel.getInstance(), MainCardPanel.SCORE_PANEL));
        optionsButton.addActionListener(new ChangePanelAction(MainCardPanel.getInstance(), MainCardPanel.OPTIONS_PANEL));
        exitButton.addActionListener(new ExitAction(ExitManager.getInstance()));

        // BORDER
        RoundedBorder border = new RoundedBorder(50, 2, null, Color.WHITE);
        menuPanel.setBorder(border);

        // ADDING COMPONENTS
        menuPanel.setNewGameButton(newGameButton);
        menuPanel.setOptionsButton(optionsButton);
        menuPanel.setScoreButton(scoreButton);
        menuPanel.setExitButton(exitButton);

        menuPanel.init();
    }

}

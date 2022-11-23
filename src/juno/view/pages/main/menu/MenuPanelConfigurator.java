package juno.view.pages.main.menu;

import juno.controller.ChangePanelAction;
import juno.controller.ExitAction;
import juno.model.data.io.output.ExitManager;
import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        MenuPanel menuPanel = MenuPanel.getInstance();

        // SUB COMPONENTS
        AbstractButton newGameButton = ButtonFactory.createButton(ButtonLibrary.NEW_GAME);
        AbstractButton optionsButton = ButtonFactory.createButton(ButtonLibrary.OPTIONS);
        AbstractButton scoreButton = ButtonFactory.createButton(ButtonLibrary.SCORE);
        AbstractButton exitButton = ButtonFactory.createButton(ButtonLibrary.EXIT);

        // RESIZE IMAGES
        ImageResizer.resize(newGameButton, 1.0);
        ImageResizer.resize(optionsButton, 3.0);
        ImageResizer.resize(scoreButton, 3.0);
        ImageResizer.resize(exitButton, 3.0);

        // ACTION LISTENERS
        newGameButton.addActionListener(new ChangePanelAction(MainCardPanel.getInstance(), MainCardPanel.NEW_GAME_PANEL));
        scoreButton.addActionListener(new ChangePanelAction(MainCardPanel.getInstance(), MainCardPanel.SCORE_PANEL));
        optionsButton.addActionListener(new ChangePanelAction(MainCardPanel.getInstance(), MainCardPanel.OPTIONS_PANEL));
        exitButton.addActionListener(new ExitAction(ExitManager.getInstance()));

        // BORDER
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // ADDING COMPONENTS
        menuPanel.setNewGameButton(newGameButton);
        menuPanel.setOptionsButton(optionsButton);
        menuPanel.setScoreButton(scoreButton);
        menuPanel.setExitButton(exitButton);

        // INITIALIZATION
        menuPanel.init();
    }
}
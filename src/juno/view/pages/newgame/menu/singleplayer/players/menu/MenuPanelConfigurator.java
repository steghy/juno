package juno.view.pages.newgame.menu.singleplayer.players.menu;

import juno.controller.ChangePanelAction;
import juno.controller.SetDifficultyAction;
import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.pages.newgame.menu.singleplayer.card.SinglePlayerCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        MenuPanel menuPanel = MenuPanel.getInstance();

        AbstractButton twoPlayers = ButtonFactory.createButton(ButtonLibrary.TWO_PLAYERS);
        AbstractButton threePlayers = ButtonFactory.createButton(ButtonLibrary.THREE_PLAYERS);
        AbstractButton fourPlayers = ButtonFactory.createButton(ButtonLibrary.FOUR_PLAYERS);
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);

        // RESIZE IMAGES
        ImageResizer.resize(twoPlayers, 3.0);
        ImageResizer.resize(threePlayers, 3.0);
        ImageResizer.resize(fourPlayers, 3.0);
        ImageResizer.resize(backButton, 3.0);

        // ACTION LISTENERS
        // [ CHANGE-PANEL-ACTION]
        twoPlayers.addActionListener(new ChangePanelAction(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.DIFFICULTY_PANEL));
        threePlayers.addActionListener(new ChangePanelAction(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.DIFFICULTY_PANEL));
        fourPlayers.addActionListener(new ChangePanelAction(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.DIFFICULTY_PANEL));
        backButton.addActionListener(new ChangePanelAction(MainCardPanel.getInstance(), MainCardPanel.NEW_GAME_PANEL));
        // [ SET DIFFICULTY-ACTION]
        twoPlayers.addActionListener(new SetDifficultyAction());
        threePlayers.addActionListener(new SetDifficultyAction());
        fourPlayers.addActionListener(new SetDifficultyAction());

        // BORDER SETTING
        RoundedBorder insideBorder = new RoundedBorder(50, 2, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 2, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        menuPanel.setBorder(border);

        // ADDING COMPONENTS
        menuPanel.setTwoPlayers(twoPlayers);
        menuPanel.setThreePlayers(threePlayers);
        menuPanel.setFourPlayers(fourPlayers);
        menuPanel.setBackButton(backButton);

        // INITIALIZATION
        menuPanel.init();
    }
}

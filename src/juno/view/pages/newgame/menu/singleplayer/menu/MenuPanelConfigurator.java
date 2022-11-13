package juno.view.pages.newgame.menu.singleplayer.menu;

import juno.controller.menu.ChangePanelAction;
import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.pages.newgame.card.NewGameCardPanel;
import juno.view.pages.newgame.menu.singleplayer.menu.difficulty.DifficultyPanel;
import juno.view.pages.newgame.menu.singleplayer.menu.playersNumber.PlayersNumberPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        MenuPanel menuPanel = MenuPanel.getInstance();

        // SUB-COMPONENTS
        DifficultyPanel difficultyPanel = DifficultyPanel.getInstance();
        PlayersNumberPanel playersNumberPanel = PlayersNumberPanel.getInstance();
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);

        // RESIZE IMAGE
        ImageResizer.resize(backButton, 3.0);

        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // ACTION LISTENERS
        backButton.addActionListener(new ChangePanelAction(NewGameCardPanel.getInstance(), NewGameCardPanel.NEW_GAME_PANEL));

        // ADDING COMPONENT
        menuPanel.setDifficultyPanel(difficultyPanel);
        menuPanel.setPlayersNumberPanel(playersNumberPanel);
        menuPanel.setBackButton(backButton);

        // INITIALIZATION
        menuPanel.init();
    }

}

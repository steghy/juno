package juno.view.pages.newgame.singleplayer.difficulty.menu;

import juno.controller.ChangePanelAction;
import juno.controller.SetDifficultyAction;
import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.pages.newgame.singleplayer.card.SinglePlayerCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        // MAIN-COMPONENTS
        MenuPanel difficultyPanel = MenuPanel.getInstance();

        // SUB-COMPONENTS
        AbstractButton easyButton = ButtonFactory.createButton(ButtonLibrary.EASY);
        AbstractButton mediumButton = ButtonFactory.createButton(ButtonLibrary.MEDIUM);
        AbstractButton hardButton = ButtonFactory.createButton(ButtonLibrary.HARD);
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);

        // RESIZE IMAGES
        ImageResizer.resize(easyButton, 3.0);
        ImageResizer.resize(mediumButton, 3.0);
        ImageResizer.resize(hardButton, 3.0);
        ImageResizer.resize(backButton, 3.0);

        // ACTION LISTENERS
        // [ CHANGE PANEL ]
        easyButton.addActionListener(new ChangePanelAction(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MODE_PANEL));
        mediumButton.addActionListener(new ChangePanelAction(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MODE_PANEL));
        hardButton.addActionListener(new ChangePanelAction(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MODE_PANEL));

        // [ SET DIFFICULTIES ]
        easyButton.addActionListener(new SetDifficultyAction());
        mediumButton.addActionListener(new SetDifficultyAction());
        hardButton.addActionListener(new SetDifficultyAction());
        backButton.addActionListener(new ChangePanelAction(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.PLAYERS_NUMBER_PANEL));

        // BORDER
        RoundedBorder insideBorder = new RoundedBorder(50, 2, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 2, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        difficultyPanel.setBorder(border);

        // ADDING COMPONENTS
        difficultyPanel.setEasyButton(easyButton);
        difficultyPanel.setMedium(mediumButton);
        difficultyPanel.setHardButton(hardButton);
        difficultyPanel.setBackButton(backButton);

        // INITIALIZATION
        difficultyPanel.init();
    }
}
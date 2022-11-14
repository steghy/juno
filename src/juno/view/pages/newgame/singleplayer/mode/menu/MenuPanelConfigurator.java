package juno.view.pages.newgame.singleplayer.mode.menu;

import juno.controller.ChangePanelAction;
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
        AbstractButton stackingModeButton = ButtonFactory.createButton(ButtonLibrary.STACKING);

        // RESIZE IMAGES
        ImageResizer.resize(stackingModeButton, 3.0);

        // ACTION LISTENERS
        stackingModeButton.addActionListener(new ChangePanelAction(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MATCH_PANEL));

        // BORDER
        RoundedBorder insideBorder = new RoundedBorder(50, 2, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 2, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        difficultyPanel.setBorder(border);

        // ADDING COMPONENTS
        difficultyPanel.setStackingModeButton(stackingModeButton);

        // INITIALIZATION
        difficultyPanel.init();
    }
}
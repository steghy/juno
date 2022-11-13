package juno.view.pages.newgame.menu.multiplayer.unavailable.menu;

import juno.controller.ChangePanelAction;
import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.pages.newgame.card.NewGameCardPanel;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        MenuPanel menuPanel = MenuPanel.getInstance();

        // SUB-COMPONENT
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);
        JLabel unavailableServiceLabel = new JLabel();

        // RESIZE IMAGE
        ImageResizer.resize(backButton, 2.0);

        // UNAVAILABLE SERVICE LABEL SETTING
        String unavailableServiceText =
                "We are sorry to inform you that unfortunately " +
                        "this mode is not yet available, however if you " +
                        "want to contribute to the development of this video game, " +
                        "please visit the site 'site here'.";
        unavailableServiceLabel.setText(unavailableServiceText);
        unavailableServiceLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 10));

        // ADDING COMPONENTS
        menuPanel.setUnavailableServiceLabel(unavailableServiceLabel);
        menuPanel.setBackButton(backButton);

        // ACTION LISTENERS
        backButton.addActionListener(new ChangePanelAction(NewGameCardPanel.getInstance(), NewGameCardPanel.NEW_GAME_PANEL));

        // INITIALIZATION
        menuPanel.init();
    }
}

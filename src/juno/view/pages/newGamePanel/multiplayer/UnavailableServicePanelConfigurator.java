package juno.view.pages.newGamePanel.multiplayer;

import juno.controller.menu.ChangePanelAction;
import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.pages.newGamePanel.NewGameCardPanel;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;

public class UnavailableServicePanelConfigurator {

    private UnavailableServicePanelConfigurator() {}

    public static void configure() {
        UnavailableServicePanel unavailableServicePanel = UnavailableServicePanel.getInstance();

        JLabel unavailableServiceLabel = new JLabel();
        AbstractButton unavailableServiceButton = ButtonFactory.createButton(ButtonLibrary.UNAVAILABLE_SERVICE);
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);

        ImageResizer.resize(unavailableServiceButton, 2.0);
        ImageResizer.resize(backButton, 2.0);

        // UNAVAILABLE SERVICE LABEL
        String unavailableServiceText =
                "We are sorry to inform you that unfortunately " +
                "this mode is not yet available, however if you " +
                "want to contribute to the development of this video game, " +
                "please visit the site 'site here'.";

        unavailableServiceLabel.setText(unavailableServiceText);
        unavailableServiceLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 10));

        // ACTION LISTENERS
        backButton.addActionListener(new ChangePanelAction(NewGameCardPanel.getInstance(), NewGameCardPanel.NEW_GAME_PANEL));

        // ADDING COMPONENTS
        unavailableServicePanel.setUnavailableServiceText(unavailableServiceLabel);
        unavailableServicePanel.setUnavailableServiceButtonImage(unavailableServiceButton);
        unavailableServicePanel.setBackButton(backButton);

        // INITIALIZATION
        unavailableServicePanel.init();
    }
}
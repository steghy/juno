package juno.view.pages.options.menu;

import juno.controller.menu.AudioToggleAction;
import juno.controller.menu.ChangePanelAction;
import juno.controller.menu.FullscreenToggleAction;
import juno.model.sound.AudioPlayer;
import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.frame.Frame;
import juno.view.util.*;

import javax.swing.*;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        MenuPanel menuPanel = MenuPanel.getInstance();

        AbstractButton audioToggle = ButtonFactory.createButton(ButtonLibrary.AUDIO_TOGGLE);
        AbstractButton fullscreenToggle = ButtonFactory.createButton(ButtonLibrary.FULLSCREEN_TOGGLE);
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);

        ImageResizer.resize(audioToggle, 2.0);
        ImageResizer.resize(fullscreenToggle, 2.0);
        ImageResizer.resize(backButton, 2.0);

        // ADDING COMPONENTS
        menuPanel.setToggleButtonMusic(audioToggle);
        menuPanel.setToggleButtonFullScreen(fullscreenToggle);
        menuPanel.setBackButton(backButton);

        // ACTION LISTENERS
        audioToggle.addActionListener(new AudioToggleAction(AudioPlayer.getInstance()));
        fullscreenToggle.addActionListener(new FullscreenToggleAction(Frame.getInstance()));
        backButton.addActionListener(new ChangePanelAction(MainCardPanel.getInstance(), MainCardPanel.MAIN_PANEL));

        // BORDER SETTINGS
        RoundedBorder border = new RoundedBorder(50, 2, null, Color.WHITE);
        menuPanel.setBorder(border);

        // INITIALIZATION
        menuPanel.init();
    }
}

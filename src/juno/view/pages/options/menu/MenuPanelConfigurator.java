package juno.view.pages.options.menu;

import juno.controller.AudioToggleAction;
import juno.controller.ChangePanelAction;
import juno.controller.FullscreenToggleAction;
import juno.model.sound.AudioPlayer;
import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.frame.Frame;
import juno.view.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        MenuPanel menuPanel = MenuPanel.getInstance();

        // SUB COMPONENT
        AbstractButton audioToggle = ButtonFactory.createButton(ButtonLibrary.AUDIO_TOGGLE);
        AbstractButton fullscreenToggle = ButtonFactory.createButton(ButtonLibrary.FULLSCREEN_TOGGLE);
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);

        // RESIZE COMPONENT
        ImageResizer.resize(audioToggle, 3.5);
        ImageResizer.resize(fullscreenToggle, 3.0);
        ImageResizer.resize(backButton, 3.0);

        // ADDING COMPONENTS
        menuPanel.setToggleButtonMusic(audioToggle);
        menuPanel.setToggleButtonFullScreen(fullscreenToggle);
        menuPanel.setBackButton(backButton);

        // ACTION LISTENERS
        audioToggle.addActionListener(new AudioToggleAction(AudioPlayer.getInstance()));
        fullscreenToggle.addActionListener(new FullscreenToggleAction(Frame.getInstance()));
        backButton.addActionListener(new ChangePanelAction(MainCardPanel.getInstance(), MainCardPanel.MAIN_PANEL));

        // BORDER SETTINGS
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // INITIALIZATION
        menuPanel.init();
    }
}
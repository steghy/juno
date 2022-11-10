package juno.view.pages.optionsPanel.menuPanel;

import juno.init.Directories;
import juno.model.sound.AudioPlayer;
import juno.model.util.PathGenerator;
import juno.view.frame.CardPanel;
import juno.view.frame.Frame;
import juno.view.util.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        MenuPanel menuPanel = MenuPanel.getInstance();

        JToggleButton toggleSwitchMusic = ToggleSwitchMusic.getInstance();
        JToggleButton toggleSwitchFullScreen = ToggleSwitchScreenSize.getInstance();
        AbstractButton back = new ImageButton();

        ImageComponentInitializer.initialize(
                back,
                Directories.BUTTONS,
                "Back",
                "back-button.png",
                "back-button-rollover.png",
                new Dimension(600, 300),
                Constant.THROW_EXCEPTION,
                Constant.KEEP_ROLLOVER_IMAGE,
                Constant.KEEP_IMAGE
        );

        ImageComponentInitializer.initialize(
                toggleSwitchFullScreen,
                Directories.BUTTONS,
                "Full/Restore screen",
                "fullscreen-mode-button.png",
                "fullscreen-mode-button-rollover.png",
                "windowed-mode-button.png",
                "windowed-mode-button-rollover.png",
                new Dimension(600, 300),

                // BOTH MISSING
                Constant.THROW_EXCEPTION,
                // BOTH SELECTED MISSING
                Constant.THROW_EXCEPTION,

                // ALL MISSING
                Constant.THROW_EXCEPTION,

                // IMAGE/ROLLOVER IMAGE MISSING
                Constant.KEEP_IMAGE,
                Constant.KEEP_ROLLOVER_IMAGE,

                // SELECTED IMAGE/ ROLLOVER SELECTED IMAGE MISSING
                Constant.KEEP_ROLLOVER_SELECTED_IMAGE,
                Constant.KEEP_SELECTED_IMAGE
        );

        ImageComponentInitializer.initialize(
                toggleSwitchMusic,
                Directories.BUTTONS,
                "Mute/Unmute music",
                "mute-button.png",
                "mute-button-rollover.png",
                "unmute-button.png",
                "unmute-button-rollover.png",
                new Dimension(600, 300),

                // BOTH MISSING
                Constant.THROW_EXCEPTION,
                // BOTH SELECTED MISSING
                Constant.THROW_EXCEPTION,

                // ALL MISSING
                Constant.THROW_EXCEPTION,

                // IMAGE/ROLLOVER IMAGE MISSING
                Constant.KEEP_IMAGE,
                Constant.KEEP_ROLLOVER_IMAGE,

                // SELECTED IMAGE/ ROLLOVER SELECTED IMAGE MISSING
                Constant.KEEP_ROLLOVER_SELECTED_IMAGE,
                Constant.KEEP_SELECTED_IMAGE
        );

        // RESIZING IMAGES
        Map<AbstractButton, Double> map = new HashMap<>();
        map.put(toggleSwitchMusic, 2.0);
        map.put(toggleSwitchFullScreen, 2.0);
        map.put(back, 2.0);
        ImageResizer.resize(map);

        // ADDING COMPONENTS
        menuPanel.setToggleButtonMusic(toggleSwitchMusic);
        menuPanel.setToggleButtonFullScreen(toggleSwitchFullScreen);
        menuPanel.setBackButton(back);

        // ACTION LISTENERS


        toggleSwitchMusic.addActionListener(listener -> {
            AudioPlayer audioPlayer = AudioPlayer.getInstance();
            if(ToggleSwitchMusic.getInstance().isSelected()) {
                audioPlayer.mute();
            } else {
                audioPlayer.unmute();
            }
        });

        // TOGGLE SWITCH FULL SCREEN
        toggleSwitchFullScreen.addActionListener(listener -> {
            String clickEffect = PathGenerator.generate(Directories.EFFECTS.absolutePath(), "click-effect.wav");
            AudioPlayer audioPlayer = AudioPlayer.getInstance();
            if(!audioPlayer.isMuted()) {
                audioPlayer.playEffect(clickEffect);
            }
            Frame frame = Frame.getInstance();
            if(ToggleSwitchScreenSize.getInstance().isSelected()) {
                frame.fullscreenMode();
            } else {
                frame.windowedMode();
            }
        });

        // BACK ACTION LISTENER
        back.addActionListener(listener -> {
            String clickEffect = PathGenerator.generate(Directories.EFFECTS.absolutePath(), "click-effect.wav");
            AudioPlayer audioPlayer = AudioPlayer.getInstance();
            if(!audioPlayer.isMuted()) {
                audioPlayer.playEffect(clickEffect);
            }
            CardLayout layout = (CardLayout) CardPanel.getInstance().getLayout();
            layout.show(CardPanel.getInstance(), CardPanel.MAIN_PANEL);
        });

        // BORDER SETTINGS
        RoundedBorder border = new RoundedBorder(50, 2, null, Color.WHITE);
        menuPanel.setBorder(border);

        // INITIALIZATION
        menuPanel.init();
    }
}

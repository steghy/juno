package juno.view.audio.panel;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.exception.JPanelNotSetException;

import javax.swing.*;

public class PanelConfigurator {

    private PanelConfigurator() {}

    public static void configure() {
        // [AUDIO PLAYER NORTH PANEL] PANELS & BUTTONS
        JButton next = new JButton();
        JButton back = new JButton();
        JToggleButton toggle = new JToggleButton();

        // CONFIGURATION
        ButtonConfigurator.configure(next);
        ButtonConfigurator.configure(back);
        ButtonConfigurator.configure(toggle);

        // [AUDIO PLAYER NORTH PANEL] IMAGE SETTING
        String nextImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "next.png");
        String pauseImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "pause-button.png");
        String playImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "play-button.png");
        String backImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "rewind.png");

        next.setIcon(new ImageIcon(ImageResizer.resize(next, nextImage)));
        toggle.setIcon(new ImageIcon(ImageResizer.resize(toggle, playImage)));
        toggle.setSelectedIcon(new ImageIcon(ImageResizer.resize(toggle, pauseImage)));
        back.setIcon(new ImageIcon(ImageResizer.resize(next, backImage)));

        // NEXT BUTTOn
        next.addActionListener(new ActionButton());
        next.setActionCommand(ActionButton.nextButton);

        // TOGGLE BUTTON
        toggle.addActionListener(new ActionButton());
        toggle.setActionCommand(ActionButton.toggleButton);

        // BACK BUTTON
        back.addActionListener(new ActionButton());
        back.setActionCommand(ActionButton.backButton);

        // [AUDIO PLAYER NORTH PANEL] CONNECTION
        Panel panel = Panel.getInstance();
        panel.setNext(next);
        panel.setToggle(toggle);
        panel.setBack(back);


        try {
            panel.init();
        } catch (JPanelNotSetException e) {
            e.printStackTrace();
        }
    }
}

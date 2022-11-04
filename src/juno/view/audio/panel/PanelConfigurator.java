package juno.view.audio.panel;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.exception.JPanelNotSetException;

import javax.swing.*;

public class PanelConfigurator {

    private PanelConfigurator() {}

    public static void configure() {
        // [AUDIO PLAYER NORTH PANEL] PANELS & BUTTONS
        Button next = new Button();
        Button toggle = new Button();
        Button back = new Button();

        // [AUDIO PLAYER NORTH PANEL] IMAGE SETTING
        String nextImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "next.png");
        String toggleImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "pause-button.png");
        String backImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "rewind.png");

        next.setIcon(new ImageIcon(nextImage));
        toggle.setIcon(new ImageIcon(toggleImage));
        back.setIcon(new ImageIcon(backImage));

        next.addActionListener(new ActionButton());
        next.setActionCommand(ActionButton.nextButton);
        toggle.addActionListener(new ActionButton());
        toggle.setActionCommand(ActionButton.playButton);
        back.addActionListener(new ActionButton());
        back.setActionCommand(ActionButton.backButton);

        // [AUDIO PLAYER NORTH PANEL] CONNECTION
        Panel panel = Panel.getInstance();
        panel.setNext(next);
        panel.setTogle(toggle);
        panel.setBack(back);


        try {
            panel.init();
        } catch (JPanelNotSetException e) {
            e.printStackTrace();
        }
    }
}

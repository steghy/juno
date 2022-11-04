package juno.view.audio.panel;

import juno.model.sound.AudioPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButton implements ActionListener {

    public static final String nextButton = "next";
    public static final String backButton = "back";
    public static final String pauseButton = "pause";
    public static final String playButton = "play";

    @Override
    public void actionPerformed(ActionEvent e) {
        AudioPlayer audioPlayer = AudioPlayer.getInstance();
        switch(e.getActionCommand()) {
            case(nextButton) -> audioPlayer.next();
            case(backButton) -> audioPlayer.previous();
            case(pauseButton) -> audioPlayer.pause();
            case(playButton) -> audioPlayer.play();
        }
    }
}

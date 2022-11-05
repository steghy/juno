package juno.controller.audio;

import juno.model.sound.AudioPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudioPlayerAction implements ActionListener {

    public static final String nextButton = "next";
    public static final String backButton = "back";
    public static final String toggleButton = "toggle";

    private static AudioPlayerAction instance;

    private AudioPlayerAction() {}

    public static AudioPlayerAction getInstance() {
        if(instance == null) {
            instance = new AudioPlayerAction();
        } return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof AbstractButton button) {
            AudioPlayer audioPlayer = AudioPlayer.getInstance();
            switch(e.getActionCommand()) {
                case(nextButton) -> audioPlayer.next();
                case(toggleButton) -> {
                    if(button instanceof JToggleButton toggle) {
                        if(audioPlayer.isRunning()) {
                            audioPlayer.pause();

                        } else {
                            audioPlayer.play();
                        }
                    }
                }
                case(backButton) -> audioPlayer.back();
            }
        } else {
            throw new IllegalArgumentException("Invalid usage");
        }
    }
}

package juno.view.audio.panel;

import juno.model.sound.AudioPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButton implements ActionListener {

    public static final String nextButton = "next";
    public static final String backButton = "back";
    public static final String toggleButton = "toggle";

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof AbstractButton button) {
            AudioPlayer audioPlayer = AudioPlayer.getInstance();

            // TOGGLE CASE
            if(button.getActionCommand().equals(toggleButton)) {
                if(audioPlayer.getStatus()) {
                    audioPlayer.pause();
                } else {
                    audioPlayer.play();
                }
            }

            // NEXT / BACK CASE
            switch(e.getActionCommand()) {
                case(nextButton) -> audioPlayer.next();
                case(backButton) -> audioPlayer.previous();
            }
        }
    }
}

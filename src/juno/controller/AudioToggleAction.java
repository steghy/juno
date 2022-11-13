package juno.controller;

import juno.model.sound.MutableAudioPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AudioToggleAction extends AbstractAction {

    private MutableAudioPlayer audioPlayer;

    public AudioToggleAction(MutableAudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(audioPlayer.isMuted()) {
            audioPlayer.unmute();
        } else {
            audioPlayer.mute();
        }
    }
}

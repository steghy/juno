package juno.init;

import juno.model.sound.AudioPlayer;
import juno.view.frame.Frame;
import juno.view.pages.optionsPanel.menuPanel.ToggleSwitchScreenSize;

import javax.swing.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        Repository.setRepository();

        try {
            ViewInitializer.initialize();
            AudioPlayer audioPlayer = AudioPlayer.getInstance();
            audioPlayer.setTracks(new File(Directories.MUSIC.absolutePath()).listFiles());
            audioPlayer.play();
            Frame frame = Frame.getInstance();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An unknown error has occurred. " +
                    "Consult the program logs for more information.");
        }
    }
}

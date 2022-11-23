package juno.init;

import juno.model.sound.AudioPlayer;
import juno.view.frame.Frame;

import javax.swing.*;
import java.io.File;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Repository.setRepository();
        try {
            ModelInitializer.initialize();
            ViewInitializer.initialize();

            AudioPlayer audioPlayer = AudioPlayer.getInstance();
            audioPlayer.setTracks(Objects
                    .requireNonNull(new File(Directories.MUSIC.absolutePath()).listFiles()));
            // audioPlayer.play();
            audioPlayer.setLoop(true);

            Frame frame = Frame.getInstance();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An unknown error has occurred. " +
                    "Consult the program logs for more information.");
        }
    }
}

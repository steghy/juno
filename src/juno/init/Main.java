package juno.init;

import juno.model.data.io.input.JSONDataImporter;
import juno.model.sound.AudioPlayer;
import juno.model.util.PathGenerator;
import juno.view.ViewInitializer;
import juno.view.factories.buttons.ButtonFactoryConfigurator;
import juno.view.frame.Frame;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        // SET REPOSITORY
        Repository.setRepository();

        try {
            // BUTTON FACTORY SETTING
            ButtonFactoryConfigurator.getInstance()
                    .configure(JSONDataImporter.getInstance()
                            .importData(PathGenerator.generate(Directories.CONFIG
                                    .absolutePath(), "button-factory-config.json")));

            // VIEW INITIALIZATION
            ViewInitializer.initialize();

            // AUDIO
            AudioPlayer audioPlayer = AudioPlayer.getInstance();
            audioPlayer.setTracks(new File(Directories.MUSIC.absolutePath()).listFiles());
            audioPlayer.play();
            audioPlayer.setLoop(true);

            // FRAME
            Frame frame = Frame.getInstance();
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An unknown error has occurred. " +
                    "Consult the program logs for more information.");
        }
    }
}

package juno.view.example;

import juno.init.Paths;
import juno.model.sound.AudioPlayer;
import juno.view.example.frame.Frame;
import juno.view.example.frame.FrameConfigurator;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String tracks = Paths.MUSIC.getPath();
        AudioPlayer.getInstance().setTracks((new File(tracks)).listFiles());
        AudioPlayer.getInstance().play();
        Frame frame = Frame.getInstance();
        FrameConfigurator.configure();
        frame.setVisible(true);
    }
}

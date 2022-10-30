package juno.model.sound.test;

import juno.init.Paths;
import juno.model.sound.AudioPlayer;

import javax.sound.sampled.FloatControl;
import java.io.File;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class FaderTester {

    public static void main(String[] args) {

        // MUSIC PATH
        String musicPath = Paths.MUSIC.getPath();

        // SETTING AUDIO PLAYER
        AudioPlayer audioPlayer = AudioPlayer.getInstance();
        audioPlayer.setTracks(new File(musicPath).listFiles());

        // GAIN CONTROLLER
        FloatControl floatControl = (FloatControl) audioPlayer.getClip()
                .getControl(FloatControl.Type.MASTER_GAIN);

        // THREAD
        Thread audioPlayerThread = new Thread(audioPlayer);

        // STARTING THREAD
        audioPlayerThread.start();

        audioPlayer.loop(false);

        BigDecimal db = BigDecimal.valueOf(0);
        while(db.floatValue() != -80) {
            System.out.println(db);
            db = db.subtract(BigDecimal.valueOf(0.001));
            floatControl.setValue(db.floatValue());
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        audioPlayerThread.interrupt();
    }
}

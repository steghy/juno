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

        // FULL VOLUME

        BigDecimal gain = BigDecimal.valueOf(1.0);
        float db = (float) (Math.log(gain.floatValue()) / Math.log(10.0) * 20.0);
        floatControl.setValue(db);
        BigDecimal subt = BigDecimal.valueOf(0.0006);

        while(gain.floatValue() > -0.0005) {
            db = (float) (Math.log(gain.floatValue()) / Math.log(10.0) * 20.0);
            System.out.println(db);
            floatControl.setValue(db);
            gain = gain.subtract(subt);
            // System.out.println(gain.floatValue());
            try {
                TimeUnit.MILLISECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        audioPlayerThread.interrupt();

    }
}

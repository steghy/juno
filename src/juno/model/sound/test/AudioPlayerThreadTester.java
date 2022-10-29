package juno.model.sound.test;

import juno.init.Paths;
import juno.model.sound.AudioPlayer;
import juno.model.sound.AudioThreadManager;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AudioPlayerThreadTester {

    public static void main(String[] args) {

        /*########### THREAD 1 ##################*/

        // MUSIC PATH
        String musicDirectory = Paths.MUSIC.getPath();
        File directory = new File(musicDirectory);

        // AUDIO PLAYER INITIALIZATION
        AudioPlayer audioPlayer = AudioPlayer.getInstance();
        audioPlayer.setTracks(directory.listFiles());

        // THREAD START
        Thread audioPlayerThread = new Thread(audioPlayer);
        audioPlayerThread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // INTERRUPTS
        audioPlayerThread.interrupt();

        /*######## THREAD 2 #######################*/

        // MUSIC PATH
        String musicDirectory2 = Paths.MUSIC_2.getPath();
        File directory2 = new File(musicDirectory2);

        // AUDIO PLAYER INITIALIZATION
        audioPlayer.setTracks(directory2.listFiles());

        // THREAD START
        Thread audioPlayerThread2 = new Thread(audioPlayer);
        audioPlayerThread2.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // INTERRUPTS
        audioPlayerThread2.interrupt();

        /*######## THREAD 3 - CUSTOM ##############*/

        // AUDIO PLAYER INITIALIZATION
        audioPlayer.setTracks(directory.listFiles());

        // THREAD START
        AudioThreadManager.openThread(new Thread(audioPlayer));
        audioPlayerThread2.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // INTERRUPTS
        audioPlayerThread2.interrupt();
    }
}
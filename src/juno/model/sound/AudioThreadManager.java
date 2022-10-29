package juno.model.sound;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class AudioThreadManager {

    public static void closeThread(Thread thread) {
        if(!thread.isAlive())
            throw new IllegalArgumentException(
                    thread + "is't alive");
        thread.interrupt();
    }

    public static void openThread(Thread thread) {
        if(thread.isAlive())
            throw new IllegalArgumentException(
                    thread + "is alive already");
        thread.start();
    }
}

package juno.model.sound;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 */
public class Fader {

    /* Clip object reference */
    private Clip clip;

    private FloatControl floatControl;

    /**
     * Builds a Fader object with the specified
     * Clip object
     * @param clip A Clip object
     */
    public Fader(Clip clip) {
        this.clip = clip;
        this.floatControl = (FloatControl) clip
                .getControl(FloatControl.Type.MASTER_GAIN);
    }

    public void fadeIn(long millisecond) {
    }
}

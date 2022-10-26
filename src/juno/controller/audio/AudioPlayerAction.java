package juno.controller.audio;

import juno.controller.audio.AbstractAudioPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerAction implements ActionListener {

    /** 'next' action command */
    public static final String NEXT = "next";

    /** 'previous' action command */
    public static final String PREVIOUS = "previous";

    /** 'toggle switch' action command */
    public static final String TOGGLE_SWITCH = "toggle switch";

    /* AbstractAudioPlayer */
    private final AbstractAudioPlayer abstractAudioPlayer;

    /**
     * Builds an AudioPlayerAction with the specified
     * AbstractAudioPlayer object.
     * @param abstractAudioPlayer An AbstractAudioPlayer concrete
     *                            instance.
     */
    public AudioPlayerAction(AbstractAudioPlayer abstractAudioPlayer) {
        this.abstractAudioPlayer = abstractAudioPlayer;
    }

    /**
     * Description here
     * @param action An ActionEvent object
     */
    public void actionPerformed(ActionEvent action) {
        String command = action.getActionCommand();
        switch(command){
            case(NEXT): abstractAudioPlayer.next(); break;
            case(PREVIOUS): abstractAudioPlayer.previous(); break;
            case(TOGGLE_SWITCH): abstractAudioPlayer.play(); break;
        }
    }
}

package juno.model.sound;

public interface MutableAudioPlayer
        extends InterfaceAudioPlayer {

    void mute();

    void unmute();

    boolean isMuted();
}

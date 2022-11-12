package juno.model.sound;

public interface MutableAudioPlayer extends AbstractAudioPlayer {

    void mute();

    void unmute();

    boolean isMuted();
}

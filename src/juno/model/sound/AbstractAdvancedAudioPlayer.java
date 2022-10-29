package juno.model.sound;

public interface AbstractAdvancedAudioPlayer extends AbstractAudioPlayer {

    void next();

    void previous();

    void stop();

    void pause();
}

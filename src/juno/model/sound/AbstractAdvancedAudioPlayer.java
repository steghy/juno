package juno.model.sound;

public interface AbstractAdvancedAudioPlayer extends AbstractAudioPlayer {

    void next();

    void back();

    void stop();

    void pause();
}

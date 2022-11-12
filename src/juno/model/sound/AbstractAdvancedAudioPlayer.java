package juno.model.sound;

public interface AbstractAdvancedAudioPlayer extends MutableAudioPlayer {

    void next();

    void back();

    void stop();

    void pause();
}

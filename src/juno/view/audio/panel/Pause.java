package juno.view.audio.panel;

public class Pause extends Button {

    private static Pause instance;

    private Pause() { super(); }

    public static Pause getInstance() {
        if(instance == null) {
            instance = new Pause();
        } return instance;
    }
}

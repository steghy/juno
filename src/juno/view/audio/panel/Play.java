package juno.view.audio.panel;

public class Play extends Button {

    private static Play instance;

    private Play() { super(); }

    public static Play getInstance() {
        if(instance == null) {
            instance = new Play();
        } return instance;
    }
}

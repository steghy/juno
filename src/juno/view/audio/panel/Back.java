package juno.view.audio.panel;

public class Back extends Button {

    private static Back instance;

    private Back() { super(); }

    public static Back getInstance() {
        if(instance == null) {
            instance = new Back();
        } return instance;
    }
}

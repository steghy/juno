package juno.view.example.frame;

public class Frame extends AbstractFrame {

    private static Frame instance;

    private Frame() {}

    public static Frame getInstance() {
        if(instance == null) {
            instance = new Frame();
        } return instance;
    }
}

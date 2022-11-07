package juno.init;

import juno.view.ViewInitializer;
import juno.view.frame.Frame;

public class Main {

    public static void main(String[] args) {
        ViewInitializer.initialize();
        Frame frame = new Frame();
        frame.setVisible(true);
    }
}

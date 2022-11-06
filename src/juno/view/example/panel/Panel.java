package juno.view.example.panel;

public class Panel extends AbstractPanel {

    private static Panel instance;

    private Panel() {}

    public static Panel getInstance() {
        if(instance == null) {
            instance = new Panel();
        } return instance;
    }
}

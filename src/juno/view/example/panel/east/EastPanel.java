package juno.view.example.panel.east;

import javax.swing.JPanel;

public class EastPanel extends JPanel {

    private static EastPanel instance;

    private EastPanel() {}

    public static EastPanel getInstance() {
        if(instance == null) {
            instance = new EastPanel();
        } return instance;
    }
}

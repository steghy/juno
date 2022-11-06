package juno.view.example.panel.south;

import javax.swing.JPanel;

public class SouthPanel extends JPanel {

    private static SouthPanel instance;

    private SouthPanel() {}

    public static SouthPanel getInstance() {
        if(instance == null) {
            instance = new SouthPanel();
        } return instance;
    }

}

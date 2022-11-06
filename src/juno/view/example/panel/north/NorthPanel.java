package juno.view.example.panel.north;

import javax.swing.JPanel;

public class NorthPanel extends JPanel {

    private static NorthPanel instance;

    private NorthPanel() {}

    public static NorthPanel getInstance() {
        if(instance == null) {
            instance = new NorthPanel();
        } return instance;
    }
}

package juno.view.example.panel.center;

import javax.swing.JPanel;

public class CenterPanel extends JPanel {

    private static CenterPanel instance;

    private CenterPanel() {}

    public static CenterPanel getInstance() {
        if(instance == null) {
            instance = new CenterPanel();
        } return instance;
    }

}

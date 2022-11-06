package juno.view.example.panel.center.center;

import javax.swing.*;

public class MenuPanel extends JPanel {

    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) {
            instance = new MenuPanel();
        } return instance;
    }
}

package juno.view.example.panel.center.center.menu.buttons;

import javax.swing.*;

public class ButtonsPanel extends JPanel {

    private static ButtonsPanel instance;

    private ButtonsPanel() {}

    public static ButtonsPanel getInstance() {
        if(instance == null) {
            instance = new ButtonsPanel();
        } return instance;
    }

}

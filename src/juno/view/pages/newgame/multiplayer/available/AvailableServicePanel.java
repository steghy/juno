package juno.view.pages.newgame.multiplayer.available;

import javax.swing.*;

public class AvailableServicePanel extends JPanel {

    private static AvailableServicePanel instance;

    private AvailableServicePanel() {}

    public static AvailableServicePanel getInstance() {
        if(instance == null) {
            instance = new AvailableServicePanel();
        } return instance;
    }

    public void init() {}
}

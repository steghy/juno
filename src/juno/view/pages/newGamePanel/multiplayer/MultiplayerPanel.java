package juno.view.pages.newGamePanel.multiplayer;

import javax.swing.*;

public class MultiplayerPanel extends JPanel {

    private static MultiplayerPanel instance;

    private MultiplayerPanel() {}

    public static MultiplayerPanel getInstance() {
        if(instance == null) {
            instance = new MultiplayerPanel();
        } return instance;
    }

    public void init() {}
}

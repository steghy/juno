package juno.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToggleSwitchMusicListener implements ActionListener {

    private static ToggleSwitchMusicListener instance;

    private ToggleSwitchMusicListener() {}

    public static ToggleSwitchMusicListener getInstance() {
        if(instance == null) {
            instance = new ToggleSwitchMusicListener();
        } return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

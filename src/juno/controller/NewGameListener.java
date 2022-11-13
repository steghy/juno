package juno.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameListener implements ActionListener {

    private static NewGameListener instance;

    private NewGameListener() {}

    public static NewGameListener getInstance() {
        if(instance == null) {
            instance = new NewGameListener();
        } return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

package juno.view.example.frame;

import juno.view.example.panel.Panel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private static Frame instance;

    private Frame() {
        init();
    }

    public static Frame getInstance() {
        if(instance == null) {
            instance = new Frame();
        } return instance;
    }

    private void init() {
        Panel panel = Panel.getInstance();
        this.add(panel);
        this.setPreferredSize(new Dimension(1200, 900));
        this.setMinimumSize(new Dimension(1200, 900));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}

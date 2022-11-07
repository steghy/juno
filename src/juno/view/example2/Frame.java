package juno.view.example2;

import juno.view.example2.panel.Panel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        init();
    }

    private void init() {
        // DEFAULT SETTINGS
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // DIMENSION
        Dimension dimension = new Dimension(1500, 1000);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);

        // COMPONENT
        Panel panel = new Panel();
        this.add(panel);
    }

}

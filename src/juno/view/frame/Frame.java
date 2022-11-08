package juno.view.frame;

import juno.view.pages.main.Panel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        init();
    }

    private void init() {
        // DIMENSION
        Dimension dimension = new Dimension(1500, 1000);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);

        // COMPONENT
        this.add(Panel.getInstance());

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}

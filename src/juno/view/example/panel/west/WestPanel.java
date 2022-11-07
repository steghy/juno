package juno.view.example.panel.west;

import javax.swing.*;
import java.awt.*;

public class WestPanel extends JPanel {

    private static WestPanel instance;

    private WestPanel() {
        init();
    }

    public static WestPanel getInstance() {
        if(instance == null) {
            instance = new WestPanel();
        } return instance;
    }

    private void init() {
        this.setOpaque(false);
        JLabel westLabel = new JLabel();
        westLabel.setOpaque(false);
        westLabel.setPreferredSize(new Dimension(300,0));
        this.add(westLabel);
    }
}

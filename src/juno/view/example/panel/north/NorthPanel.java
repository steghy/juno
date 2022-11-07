package juno.view.example.panel.north;

import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {

    private static NorthPanel instance;

    private NorthPanel() {
        init();
    }

    public static NorthPanel getInstance() {
        if(instance == null) {
            instance = new NorthPanel();
        } return instance;
    }

    private void init() {
        this.setOpaque(false);
        JLabel northLabel = new JLabel();
        northLabel.setOpaque(false);
        northLabel.setPreferredSize(new Dimension(0, 0));
        this.add(northLabel);
    }
}

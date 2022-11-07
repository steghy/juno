package juno.view.example.panel;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.example.panel.center.CenterPanel;
import juno.view.example.panel.east.EastPanel;
import juno.view.example.panel.north.NorthPanel;
import juno.view.example.panel.south.SouthPanel;
import juno.view.example.panel.west.WestPanel;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private static Panel instance;

    private Panel() {
        init();
    }

    public static Panel getInstance() {
        if(instance == null) {
            instance = new Panel();
        } return instance;
    }

    private void init() {
        JLabel background = new JLabel();
        NorthPanel northPanel = NorthPanel.getInstance();
        CenterPanel centerPanel = CenterPanel.getInstance();
        SouthPanel southPanel = SouthPanel.getInstance();
        WestPanel westPanel = WestPanel.getInstance();
        EastPanel eastPanel = EastPanel.getInstance();

        String backgroundImage = PathGenerator.generate(Paths.BACKGROUNDS.getPath(), "background.gif");
        background.setIcon(new ImageIcon(backgroundImage));

        this.add(background);
        background.setLayout(new BorderLayout());
        background.add(northPanel, BorderLayout.NORTH);
        background.add(centerPanel, BorderLayout.CENTER);
        background.add(southPanel, BorderLayout.SOUTH);
        background.add(westPanel, BorderLayout.WEST);
        background.add(eastPanel, BorderLayout.EAST);
    }
}
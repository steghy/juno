package juno.view.example.frame;

import juno.view.example.panel.Panel;
import juno.view.example.panel.PanelConfigurator;

import javax.swing.*;
import java.awt.*;

public class FrameConfigurator {

    private FrameConfigurator() {}

    public static void configure() {
        Frame frame = Frame.getInstance();

        Panel panel = Panel.getInstance();
        PanelConfigurator.configure();

        frame.setPanel(panel);
        frame.setPreferredSize(new Dimension(1200, 900));
        frame.setMinimumSize(new Dimension(1200, 900));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        frame.init();
    }
}

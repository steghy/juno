package juno.view.util;

import javax.swing.*;
import java.awt.*;

public class FrameConfigurator {

    private FrameConfigurator() {}

    public static void configure(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        // frame.setLocationRelativeTo(null);
    }
}

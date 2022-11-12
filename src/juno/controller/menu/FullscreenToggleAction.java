package juno.controller.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FullscreenToggleAction extends AbstractAction {

    private JFrame frame;
    private GraphicsDevice fullscreenDevice;

    public FullscreenToggleAction (JFrame frame) {
        this(frame, GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice());
    }

    public FullscreenToggleAction (JFrame frame, GraphicsDevice fullscreenDevice) {
        this.frame = frame;
        this.fullscreenDevice = fullscreenDevice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();

        if (frame.isUndecorated()) {
            fullscreenDevice.setFullScreenWindow(null);
            frame.setUndecorated(false);
        } else {
            frame.setUndecorated(true);
            fullscreenDevice.setFullScreenWindow(frame);
        }

        frame.setVisible(true);
        frame.repaint();
    }
}

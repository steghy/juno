package juno.view.frame;

import juno.view.backgrounds.Background;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {


    public static final GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];
    public static final int DEFAULT_WIDTH = 1500;
    public static final int DEFAULT_HEIGHT = 1500;
    private static Frame instance;
    private boolean fullscreen;

    private Frame() {
        init();
    }

    public static Frame getInstance() {
        if(instance == null) {
            instance = new Frame();
        } return instance;
    }

    private void init() {
        fullscreen = true;
        Dimension dimension = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        Background background = Background.getInstance();
        background.setLayout(new BorderLayout());
        background.add(CardPanel.getInstance(), BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.add(background, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        device.setFullScreenWindow(this);
    }

    public boolean isFullScreen() {
        return fullscreen;
    }
}

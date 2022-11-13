package juno.view.frame;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame implements AbstractResizableFrame {

    public static GraphicsDevice device = GraphicsEnvironment
                                          .getLocalGraphicsEnvironment()
                                          .getScreenDevices()[0];
    public static final int DEFAULT_WIDTH = 1500;
    public static final int DEFAULT_HEIGHT = 1500;
    private JLabel background;
    private JPanel panel;
    private static Frame instance;

    private Frame() {}

    public static Frame getInstance() {
        if(instance == null) {
            instance = new Frame();
        } return instance;
    }

    public void init() {
        if(background == null) {
            throw new IllegalArgumentException("Background is null");
        } if(panel == null) {
            throw new IllegalArgumentException("Panel is null");
        }

        setLayout(new BorderLayout());
        setDefaultDimension();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        background.setLayout(new BorderLayout());
        background.setOpaque(false);
        background.add(panel, BorderLayout.CENTER);
        add(background, BorderLayout.CENTER);
    }

    public static void addKeyBinding(JComponent c, String key, final Action action) {
        c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), key);
        c.getActionMap().put(key, action);
        c.setFocusable(true);
    }

    public void setDefaultDimension() {
        Dimension dimension = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
    }

    public void fullscreenMode() {
        device.setFullScreenWindow(this);
    }

    public void windowedMode() {
        device.setFullScreenWindow(null);
    }

    public void setBackground(JLabel background) {
        this.background = background;
    }

    public JLabel getBackgroundFrame() {
        return background;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }



}

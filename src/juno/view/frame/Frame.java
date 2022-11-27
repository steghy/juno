/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.view.frame;

import javax.swing.*;
import java.awt.*;

public class Frame
        extends JFrame
        implements AbstractResizableFrame {

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
        if(instance == null) instance = new Frame();
        return instance;
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

    public void setDefaultDimension() {
        Dimension dimension = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
    }

    public void setBackground(JLabel background) {
        this.background = background;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
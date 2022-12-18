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

package juno.controller.util;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Simone Gentili
 */
public class FullscreenToggleAction
        implements ActionListener {

    // The frame.
    private final JFrame frame;

    // The graphics device.
    private final GraphicsDevice fullscreenDevice;

    /**
     * Builds a FullScreenToggleAction with the
     * specified JFrame object.
     * @param frame A JFrame object.
     */
    public FullscreenToggleAction(@NotNull JFrame frame) {
        this(frame, GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice());
    }

    /**
     * Builds a FullscreenToggleAction with the
     * specified JFrame and GraphicsDevice objects.
     * @param frame A JFrame object.
     * @param fullscreenDevice A GraphicsDevice object.
     */
    public FullscreenToggleAction (@NotNull JFrame frame,
                                   @NotNull GraphicsDevice fullscreenDevice) {
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
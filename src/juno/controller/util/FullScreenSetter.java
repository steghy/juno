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

import juno.model.util.AbstractObservable;
import juno.model.util.Setter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * This class defines a fullscreen setter.
 * @author Simone Gentili
 */
public class FullScreenSetter
        extends AbstractObservable
        implements Setter<JFrame> {

    // The Graphics device.
    private final GraphicsDevice device;

    // The FullScreenSetter instance.
    private static FullScreenSetter instance;

    // Builds the FullScreenSetter instance.
    private FullScreenSetter() {
        this.device = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
    }

    /**
     * Returns the FullScreenSetter instance.
     * @return The FullScreenSetter instance.
     */
    public static FullScreenSetter getInstance() {
        if(instance == null) instance = new FullScreenSetter();
        return instance;
    }

    @Override
    public void set(@NotNull JFrame frame) {
        frame.dispose();
        if (frame.isUndecorated()) {
            device.setFullScreenWindow(null);
            frame.setUndecorated(false);
        } else {
            frame.setUndecorated(true);
            device.setFullScreenWindow(frame);
        }
        frame.setVisible(true);
        frame.repaint();
    }

}
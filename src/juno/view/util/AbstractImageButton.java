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

package juno.view.util;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
@SuppressWarnings("ALL")
public abstract class AbstractImageButton
        extends JButton {

    public void setSize(@NotNull Dimension dimension) {
        if(dimension.getWidth() != 0 &&
                dimension.getHeight() != 0) {
            super.setSize(dimension);
            Icon icon = getIcon();
            Icon rolloverIcon = getRolloverIcon();
            if(icon != null) {
                setIcon(new ImageIcon(ImageResizer.resize(this, icon)));
            } if(rolloverIcon != null) {
                setRolloverIcon(new ImageIcon(ImageResizer.resize(this, rolloverIcon)));
            }
        }
    }

    public void setSize(int width,
                        int height) {
        if(width != 0 && height != 0) {
            super.setSize(width, height);
            Icon icon = getIcon();
            Icon rolloverIcon = getRolloverIcon();
            if(icon != null) {
                setIcon(new ImageIcon(ImageResizer.resize(this, icon)));
            } if(rolloverIcon != null) {
                setRolloverIcon(new ImageIcon(ImageResizer.resize(this, rolloverIcon)));
            }
        }
    }

    public void setPreferredSize(@NotNull Dimension dimension) {
        if(dimension.getWidth() != 0 &&
                dimension.getHeight() != 0) {
            super.setPreferredSize(dimension);
            super.setSize(dimension);
            Icon icon = getIcon();
            Icon rolloverIcon = getRolloverIcon();
            if(icon != null) {
                setIcon(new ImageIcon(ImageResizer.resize(this, icon)));
            } if(rolloverIcon != null) {
                setRolloverIcon(new ImageIcon(ImageResizer.resize(this, rolloverIcon)));
            }
        }
    }

}
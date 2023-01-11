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
 * This class defines an image toggle button.
 * @author Simone Gentili
 */
public class ImageToggleButton
        extends JToggleButton {

    /** The image resizer. */
    private InterfaceImageResizer resizer;

    /**
     * Builds an ImageToggleButton with the
     * specified image resizer object.
     * @param resizer An InterfaceImageResizer object.
     */
    public ImageToggleButton(@NotNull InterfaceImageResizer resizer) {
        this.resizer = resizer;
    }

    @Override
    public void setSize(@NotNull Dimension dimension) {
        if(dimension.getWidth() != 0 &&
                dimension.getHeight() != 0) {
            super.setSize(dimension);
            set();
        }
    }

    @Override
    public void setSize(int width,
                        int height) {
        if(width != 0 && height != 0) {
            super.setSize(width, height);
            set();
        }
    }

    @Override
    public void setPreferredSize(@NotNull Dimension dimension) {
        if(dimension.getWidth() != 0 &&
                dimension.getHeight() != 0) {
            super.setPreferredSize(dimension);
            set();
        }
    }

    private void set() {
        // Icons.
        Icon icon = getIcon();
        Icon rolloverIcon = getRolloverIcon();
        Icon disabledIcon = getDisabledIcon();
        Icon selectedIcon = getSelectedIcon();
        Icon rolloverSelectedIcon = getRolloverSelectedIcon();

        // Icon.
        ImageIcon imageIcon;
        if(icon != null) {
            imageIcon = new ImageIcon(resizer.resize(this, icon));
            if(icon instanceof RotatedIcon rotatedIcon) {
                setIcon(new RotatedIcon(imageIcon, rotatedIcon.getRotate()));
            } else setIcon(imageIcon);
        }

        // Rollover icon.
        if(rolloverIcon != null) {
            imageIcon = new ImageIcon(resizer.resize(this, rolloverIcon));
            if(rolloverIcon instanceof RotatedIcon rotatedIcon) {
                setRolloverIcon(new RotatedIcon(imageIcon, rotatedIcon.getRotate()));
            } else setRolloverIcon(imageIcon);
        }

        // Disabled icon.
        if(disabledIcon != null) {
            imageIcon = new ImageIcon(resizer.resize(this, disabledIcon));
            if(disabledIcon instanceof RotatedIcon rotatedIcon) {
                setDisabledIcon(new RotatedIcon(imageIcon, rotatedIcon.getRotate()));
            } else setDisabledIcon(imageIcon);
        }

        // Selected icon.
        if(selectedIcon != null) {
            imageIcon = new ImageIcon(resizer.resize(this, selectedIcon));
            if(selectedIcon instanceof RotatedIcon rotatedIcon) {
                setSelectedIcon(new RotatedIcon(imageIcon, rotatedIcon.getRotate()));
            } else setSelectedIcon(imageIcon);
        }

        // Rollover selected icon.
        if(rolloverSelectedIcon != null) {
            imageIcon = new ImageIcon(resizer.resize(this, rolloverSelectedIcon));
            if(rolloverSelectedIcon instanceof RotatedIcon rotatedIcon) {
                setRolloverSelectedIcon(new RotatedIcon(imageIcon, rotatedIcon.getRotate()));
            } else setRolloverSelectedIcon(imageIcon);
        }
    }

    /**
     * Sets the image resizer of this object.
     * @param resizer An InterfaceImageResizer object.
     */
    public void setResizer(@NotNull InterfaceImageResizer resizer) {
        this.resizer = resizer;
    }

    /**
     * Returns the imager resizer of this object.
     * @return An InterfaceImageResizer object.
     */
    public InterfaceImageResizer getResizer() {
        return resizer;
    }

}
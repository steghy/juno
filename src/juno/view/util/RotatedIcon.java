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
 *  The RotatedIcon allows you to change the orientation of an Icon by
 *  rotating the Icon before it is painted. This class supports the following
 *  orientations:
 *
 * <ul>
 * <li>DOWN - rotated 90 degrees
 * <li>UP (default) - rotated -90 degrees
 * <li>UPSIDE_DOWN - rotated 180 degrees
 * <li>ABOUT_CENTER - the icon is rotated by the specified degrees about its center.
 * </ul>
 */
public class RotatedIcon implements Icon {

    /**
     * This class defines Rotate objects.
     */
    public enum Rotate {
        /** Down. */
        DOWN,
        /** Up. */
        UP,
        /** Upside down. */
        UPSIDE_DOWN,
        /** About center. */
        ABOUT_CENTER
    }

    // The Icon object.
    private final Icon icon;

    // The Rotate object.
    private final Rotate rotate;

    // Degrees.
    private double degrees;

    // The boolean circular icon value.
    private boolean circularIcon;

    /**
     * Builds a RotatedIcon with the
     * specified Icon object.
     * @param icon An Icon object.
     */
    public RotatedIcon(@NotNull Icon icon) {
        this(icon, Rotate.ABOUT_CENTER);
    }

    /**
     * Builds a RotatedIcon with the
     * specified Icon object and Rotate object.
     * @param icon An Icon object.
     * @param rotate A Rotate object.
     */
    public RotatedIcon(@NotNull Icon icon,
                       @NotNull Rotate rotate) {
        this.icon = icon;
        this.rotate = rotate;
    }

    /**
     *  Gets the Icon to be rotated
     *  @return the Icon to be rotated
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     *  Gets the Rotate enum which indicates the direction of rotation
     *  @return the Rotate enum
     */
    public Rotate getRotate() {
        return rotate;
    }

    @Override
    public int getIconWidth() {
        if(rotate == Rotate.ABOUT_CENTER) {
            if (circularIcon) return icon.getIconWidth();
            else {
                double radians = Math.toRadians(degrees);
                double sin = Math.abs(Math.sin(radians));
                double cos = Math.abs(Math.cos(radians));
                return (int) Math.floor(icon.getIconWidth() * cos + icon.getIconHeight() * sin);
            }
        } else if (rotate == Rotate.UPSIDE_DOWN) return icon.getIconWidth();
        else return icon.getIconHeight();
    }

    @Override
    public int getIconHeight() {
        if(rotate == Rotate.ABOUT_CENTER) {
            if (circularIcon) return icon.getIconHeight();
            else {
                double radians = Math.toRadians( degrees );
                double sin = Math.abs( Math.sin( radians ) );
                double cos = Math.abs( Math.cos( radians ) );
                return (int)Math.floor(icon.getIconHeight() * cos + icon.getIconWidth() * sin);
            }
        } else if (rotate == Rotate.UPSIDE_DOWN) return icon.getIconHeight();
        else return icon.getIconWidth();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D)g.create();
        int cWidth = icon.getIconWidth() / 2;
        int cHeight = icon.getIconHeight() / 2;
        int xAdjustment = (icon.getIconWidth() % 2) == 0 ? 0 : -1;
        int yAdjustment = (icon.getIconHeight() % 2) == 0 ? 0 : -1;
        if (rotate == Rotate.DOWN) {
            g2.translate(x + cHeight, y + cWidth);
            g2.rotate(Math.toRadians(90));
            icon.paintIcon(c, g2,  -cWidth, yAdjustment - cHeight);
        } else if (rotate == Rotate.UP) {
            g2.translate(x + cHeight, y + cWidth);
            g2.rotate( Math.toRadians(-90));
            icon.paintIcon(c, g2,  xAdjustment - cWidth, -cHeight);
        } else if (rotate == Rotate.UPSIDE_DOWN) {
            g2.translate(x + cWidth, y + cHeight);
            g2.rotate( Math.toRadians(180));
            icon.paintIcon(c, g2, xAdjustment - cWidth, yAdjustment - cHeight);
        } else if (rotate == Rotate.ABOUT_CENTER) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setClip(x, y, getIconWidth(), getIconHeight());
            g2.translate((getIconWidth() - icon.getIconWidth()) / 2, (getIconHeight() - icon.getIconHeight()) / 2);
            g2.rotate(Math.toRadians(degrees), x + cWidth, y + cHeight);
            icon.paintIcon(c, g2, x, y);
        } g2.dispose();
    }

}
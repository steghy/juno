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

import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

@SuppressWarnings("ALL")
public class RoundedBorder implements Border {

    private int radius;
    private int thickness;
    private Color color;
    private Color internalColor;
    private Stroke stroke;
    private RenderingHints hints;

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    public RoundedBorder() {}

    public RoundedBorder(int radius,
                         int thickness,
                         Color internalColor,
                         Color color){
        this.radius = radius;
        this.thickness = thickness;
        this.color = color;
        this.internalColor = internalColor;
        this.stroke = new BasicStroke(thickness);
        this.hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        Shape roundRect = new RoundRectangle2D.Double(x + thickness / 2,
                y + thickness / 2,
                width - thickness,
                height - thickness,
                radius,
                radius);

        Area area = new Area(roundRect);

        final Rectangle componentRect = c.getBounds();

        if (internalColor != null) {
            g2.setColor(internalColor);
            g2.fillRoundRect(x + thickness / 2, y + thickness / 2, width - thickness, height - thickness, radius, radius);
        }

        g2.setColor(color);
        g2.setRenderingHints(hints);
        g2.setStroke(stroke);
        g2.draw(area);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius, radius, radius, radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}

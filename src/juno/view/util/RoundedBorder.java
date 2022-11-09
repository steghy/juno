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

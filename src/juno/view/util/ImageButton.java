package juno.view.util;

import javax.swing.*;
import java.awt.*;

public abstract class ImageButton extends JButton {

    public void setSize(Dimension dimension) {
        if(dimension != null &&
                dimension.getWidth() != 0 && dimension.getHeight() != 0) {
            super.setSize(dimension);
            Icon icon = getIcon();
            Icon rolloverIcon = getRolloverIcon();
            if(icon != null && rolloverIcon != null) {
                setIcon(new ImageIcon(ImageResizer.resize(this, icon)));
                setRolloverIcon(new ImageIcon(ImageResizer.resize(this, rolloverIcon)));
            }
        }
    }

    public void setSize(int width, int height) {
        if(width != 0 && height != 0) {
            super.setSize(width, height);
            Icon icon = getIcon();
            Icon rolloverIcon = getRolloverIcon();
            if(icon != null && rolloverIcon != null) {
                setIcon(new ImageIcon(ImageResizer.resize(this, icon)));
                setRolloverIcon(new ImageIcon(ImageResizer.resize(this, rolloverIcon)));
            }
        }
    }

    public void setPreferredSize(Dimension dimension) {
        System.out.println(dimension);
        if(dimension != null &&
                dimension.getWidth() != 0 && dimension.getHeight() != 0) {
            super.setPreferredSize(dimension);
            super.setSize(dimension);
            System.out.println(dimension);
            Icon icon = getIcon();
            Icon rolloverIcon = getRolloverIcon();
            if(icon != null && rolloverIcon != null) {
                setIcon(new ImageIcon(ImageResizer.resize(this, icon)));
                setRolloverIcon(new ImageIcon(ImageResizer.resize(this, rolloverIcon)));
            }
        }
    }

    public void init() {
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
    }
}

package juno.view.util;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractImageToggleButton extends JToggleButton {

    public void setSize(Dimension dimension) {
        if(dimension != null &&
                dimension.getWidth() != 0 && dimension.getHeight() != 0) {
            super.setSize(dimension);
            Icon icon = getIcon();
            Icon rolloverIcon = getRolloverIcon();
            Icon selectedIcon = getSelectedIcon();
            Icon rolloverSelectedIcon = getRolloverSelectedIcon();
            if(icon != null) {
                setIcon(new ImageIcon(ImageResizer.resize(this, icon)));
            } if(rolloverIcon != null) {
                setRolloverIcon(new ImageIcon(ImageResizer.resize(this, rolloverIcon)));
            }
            if(selectedIcon != null) {
                setSelectedIcon(new ImageIcon(ImageResizer.resize(this, selectedIcon)));
            } if(rolloverSelectedIcon != null) {
                setRolloverSelectedIcon(new ImageIcon(ImageResizer.resize(this, rolloverSelectedIcon)));
            }
        }
    }

    public void setSize(int width, int height) {
        if(width != 0 && height != 0) {
            super.setSize(width, height);
            Icon icon = getIcon();
            Icon rolloverIcon = getRolloverIcon();
            Icon selectedIcon = getSelectedIcon();
            Icon rolloverSelectedIcon = getRolloverSelectedIcon();
            if(icon != null) {
                setIcon(new ImageIcon(ImageResizer.resize(this, icon)));
            } if(rolloverIcon != null) {
                setRolloverIcon(new ImageIcon(ImageResizer.resize(this, rolloverIcon)));
            }
            if(selectedIcon != null) {
                setSelectedIcon(new ImageIcon(ImageResizer.resize(this, selectedIcon)));
            } if(rolloverSelectedIcon != null) {
                setRolloverSelectedIcon(new ImageIcon(ImageResizer.resize(this, rolloverSelectedIcon)));
            }
        }
    }

    public void setPreferredSize(Dimension dimension) {
        if(dimension != null &&
                dimension.getWidth() != 0 && dimension.getHeight() != 0) {
            super.setPreferredSize(dimension);
            super.setSize(dimension);
            Icon icon = getIcon();
            Icon rolloverIcon = getRolloverIcon();
            Icon selectedIcon = getSelectedIcon();
            Icon rolloverSelectedIcon = getRolloverSelectedIcon();
            if(icon != null) {
                setIcon(new ImageIcon(ImageResizer.resize(this, icon)));
            } if(rolloverIcon != null) {
                setRolloverIcon(new ImageIcon(ImageResizer.resize(this, rolloverIcon)));
            }
            if(selectedIcon != null) {
                setSelectedIcon(new ImageIcon(ImageResizer.resize(this, selectedIcon)));
            } if(rolloverSelectedIcon != null) {
                setRolloverSelectedIcon(new ImageIcon(ImageResizer.resize(this, rolloverSelectedIcon)));
            }
        }
    }
}
package juno.view.util;

import javax.swing.*;
import java.awt.*;

public class ImageResizer {

    private ImageResizer() {}

    public static Image resize(Component component, String path) {
        if(component != null && path != null) {
            ImageIcon image = new ImageIcon(path);
            return image.getImage().getScaledInstance(
                    component.getWidth(),
                    component.getHeight(), 0);
        } else {
            return null;
        }
    }

    public static Image resize(Component component, ImageIcon icon) {
        if(component != null && icon != null) {
            return  icon.getImage().getScaledInstance(
                    component.getWidth(),
                    component.getHeight(), 0);
        } else {
            return null;
        }
    }

    public static Image resize(Component component, Icon icon) {
        if(component != null && icon != null) {
            if (icon instanceof ImageIcon image) {
                return image.getImage().getScaledInstance(
                        component.getWidth(),
                        component.getHeight(), 0);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static Image resize(Component component, Image image) {
        if(component != null && image != null) {
            return  image.getScaledInstance(
                    component.getWidth(),
                    component.getHeight(), 0);
        } else {
            return null;
        }
    }
}

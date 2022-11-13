package juno.view.util;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

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

    public static void resize(AbstractButton button, double divisor) {
        if(button == null) {
            throw new IllegalArgumentException("Button is null");
        } if(divisor == 0) {
            throw new IllegalArgumentException("Divisor is zero");
        } if(button.getIcon() == null) {
            throw new IllegalArgumentException("Icon is null");
        } else {
            Icon icon = button.getIcon();
            button.setPreferredSize(new Dimension(
                    (int) (icon.getIconWidth() / divisor),
                    (int) (icon.getIconHeight()/ divisor)));
        }
    }
}

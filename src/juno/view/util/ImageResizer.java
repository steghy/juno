package juno.view.util;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class ImageResizer {

    private ImageResizer() {}

    public static Image resize(Component component, String path) {
        ImageIcon image = new ImageIcon(path);
        return image.getImage().getScaledInstance(
                component.getWidth(),
                component.getHeight(), 0);
    }

    public static Image resize(@NotNull Component component, @NotNull ImageIcon icon) {
        return  icon.getImage().getScaledInstance(
                component.getWidth(),
                component.getHeight(), 0);

    }

    public static Image resize(@NotNull Component component, @NotNull Icon icon) {
        if (icon instanceof ImageIcon image) {
            return image.getImage().getScaledInstance(
                    component.getWidth(),
                    component.getHeight(), 0);
        } else {
            return null;
        }
    }

    public static Image resize(@NotNull Component component, @NotNull Image image) {
        return  image.getScaledInstance(
                component.getWidth(),
                component.getHeight(), 0);
    }

    public static void resize(@NotNull AbstractButton button, double divisor) {
        Icon icon = button.getIcon();
        button.setPreferredSize(new Dimension(
                (int) (icon.getIconWidth() / divisor),
                (int) (icon.getIconHeight()/ divisor)));
    }
}

package juno.view.util;

import juno.model.util.Os;

import javax.swing.*;
import java.awt.*;

public class ImageResizer {

    private ImageResizer() {}

    public static Image resize(Component component, String path) {
        if(Os.exists(path)) {
            ImageIcon image = new ImageIcon(path);
            return image.getImage().getScaledInstance(
                    component.getWidth(),
                    component.getHeight(), 0);
        } else {
            throw new IllegalArgumentException("Path not exists");
        }
    }
}

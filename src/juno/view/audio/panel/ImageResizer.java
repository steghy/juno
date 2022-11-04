package juno.view.audio.panel;

import juno.model.util.Os;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageResizer {

    private ImageResizer() {}

    public static Image resize(AbstractButton button, String path) {
        if(Os.exists(path)) {
            ImageIcon image = new ImageIcon(path);
            return image.getImage().getScaledInstance(
                    button.getWidth(),
                    button.getHeight(), 0);
        } else {
            throw new IllegalArgumentException("Path not exists");
        }
    }
}

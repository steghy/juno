package juno.view.util;

import javax.swing.*;
import java.awt.*;

public class ComponentResizer {

    private ComponentResizer() {}

    public static void resize(Component reference, Component toResize) {
        toResize.setSize(reference.getWidth(), reference.getHeight());
    }
}

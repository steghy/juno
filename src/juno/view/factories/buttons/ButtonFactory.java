package juno.view.factories.buttons;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;
import juno.view.util.ImageToggleButton;

import javax.swing.*;
import java.awt.*;

public class ButtonFactory {

    protected static String extension = ".png";
    protected static String rollover = "_ROLLOVER";
    protected static String selected = "_SELECTED";
    protected static boolean download = true;

    private ButtonFactory() {}

    public static AbstractButton createButton(ButtonLibrary BUTTON) {
        AbstractButton button;
        if(BUTTON.name().endsWith("TOGGLE")) {
            button = new ImageToggleButton();
            ImageComponentInitializer.initialize(
                    button,
                    Directories.BUTTONS,
                    download,
                    BUTTON.name(),
                    BUTTON.name() + extension,
                    BUTTON.name() + rollover + extension,
                    BUTTON.name() + selected + extension,
                    BUTTON.name() + selected + rollover + extension,
                    new Dimension(600, 300),
                    Constant.THROW_EXCEPTION,
                    Constant.THROW_EXCEPTION,
                    Constant.THROW_EXCEPTION,
                    Constant.KEEP_ROLLOVER_IMAGE,
                    Constant.KEEP_IMAGE,
                    Constant.KEEP_ROLLOVER_SELECTED_IMAGE,
                    Constant.KEEP_SELECTED_IMAGE
            );
        } else {
            button = new ImageButton();
            ImageComponentInitializer.initialize(
                    button,
                    Directories.BUTTONS,
                    true,
                    BUTTON.name(),
                    BUTTON.name() + extension,
                    BUTTON.name() + rollover + extension,
                    new Dimension(600, 300),
                    Constant.THROW_EXCEPTION,
                    Constant.KEEP_ROLLOVER_IMAGE,
                    Constant.KEEP_IMAGE
            );
        }

        return button;
    }
}
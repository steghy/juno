package juno.view.factories.buttons;

import juno.init.Directories;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;
import juno.view.util.ImageToggleButton;

import javax.swing.*;
import java.awt.*;

public class ButtonFactory {

    public static final String EXTENSION = ".png";
    public static final String ROLLOVER = "_ROLLOVER";
    public static final String SELECTED = "_SELECTED";

    private ButtonFactory() {}

    public static AbstractButton createButton(ButtonLibrary BUTTON) {
        AbstractButton button;
        if(BUTTON.name().endsWith("TOGGLE")) {
            button = new ImageToggleButton();
            ImageComponentInitializer.initialize(
                    button,
                    Directories.BUTTONS,
                    BUTTON.name(),
                    BUTTON.name() + EXTENSION,
                    BUTTON.name() + ROLLOVER + EXTENSION,
                    BUTTON.name() + SELECTED + EXTENSION,
                    BUTTON.name() + SELECTED + ROLLOVER + EXTENSION,
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
                    BUTTON.name(),
                    BUTTON.name() + EXTENSION,
                    BUTTON.name() + ROLLOVER + EXTENSION,
                    new Dimension(600, 300),
                    Constant.THROW_EXCEPTION,
                    Constant.KEEP_ROLLOVER_IMAGE,
                    Constant.KEEP_IMAGE
            );
        }

        return button;
    }
}

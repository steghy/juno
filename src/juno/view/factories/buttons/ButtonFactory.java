package juno.view.factories.buttons;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;
import juno.view.util.ImageToggleButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("ALL")
public class ButtonFactory {

    private static String extension = ".png";
    private static String rollover = "_ROLLOVER";
    private static String selected = "_SELECTED";
    private static boolean download = true;
    private static Constant bothMissing = Constant.THROW_EXCEPTION;
    private static Constant bothSelectedMissing = Constant.THROW_EXCEPTION;
    private static Constant allMissing = Constant.THROW_EXCEPTION;
    private static Constant imageMissing = Constant.KEEP_ROLLOVER_IMAGE;
    private static Constant rolloverImageMissing = Constant.KEEP_IMAGE;
    private static Constant selectedImageMissing = Constant.KEEP_ROLLOVER_SELECTED_IMAGE;
    private static Constant rolloverSelectedImageMissing = Constant.KEEP_SELECTED_IMAGE;
    private static Dimension dimension = new Dimension(500, 250);

    private ButtonFactory() {}

    public static AbstractButton createButton(@NotNull ButtonLibrary BUTTON) {
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
                    dimension,
                    bothMissing,
                    bothSelectedMissing,
                    allMissing,
                    imageMissing,
                    rolloverImageMissing,
                    selectedImageMissing,
                    rolloverSelectedImageMissing
            );
        } else {
            button = new ImageButton();
            ImageComponentInitializer.initialize(
                    button,
                    Directories.BUTTONS,
                    download,
                    BUTTON.name(),
                    BUTTON.name() + extension,
                    BUTTON.name() + rollover + extension,
                    dimension,
                    bothMissing,
                    imageMissing,
                    rolloverImageMissing
            );
        }

        return button;
    }
}
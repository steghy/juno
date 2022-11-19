package juno.view.factories.buttons;

import juno.init.Directories;
import juno.model.data.io.output.Exportable;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;
import juno.view.util.ImageToggleButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ButtonFactory implements Exportable {

    private static String extension = ".png";
    private static String rollover = "_ROLLOVER";
    private static String selected = "_SELECTED";
    private static MyObject myObject = new MyObject("Ciao", 10);
    private static boolean download = true;
    private static Constant bothMissing = Constant.THROW_EXCEPTION;
    private static Constant bothSelectedMissing = Constant.THROW_EXCEPTION;
    private static Constant allMissing = Constant.THROW_EXCEPTION;
    private static Constant imageMissing = Constant.KEEP_ROLLOVER_IMAGE;
    private static Constant rolloverImageMissing = Constant.KEEP_IMAGE;
    private static Constant selectedImageMissing = Constant.KEEP_ROLLOVER_SELECTED_IMAGE;
    private static Constant rolloverSelectedImageMissing = Constant.KEEP_SELECTED_IMAGE;
    private static Dimension dimension = new Dimension(500, 250);

    // private ButtonFactory() {}

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

    @Override
    public Map<String, Object> getDataMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("extension", extension);
        map.put("rollover", rollover);
        map.put("selected", selected);
        map.put("download", download);
        map.put("bothMissing", bothMissing);
        map.put("bothSelectedMissing", bothSelectedMissing);
        map.put("myObject", myObject);
        map.put("allMissing", allMissing);
        map.put("imageMissing", imageMissing);
        map.put("rolloverImageMissing", rolloverImageMissing);
        map.put("selectedImageMissing", selectedImageMissing);
        map.put("rolloverSelectedImageMissing", rolloverSelectedImageMissing);
        map.put("dimension", dimension);
        return map;
    }
}
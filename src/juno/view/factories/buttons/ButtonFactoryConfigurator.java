package juno.view.factories.buttons;

import juno.model.data.io.input.Configurable;
import juno.view.util.Constant;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ButtonFactoryConfigurator implements Configurable {

    public static final String EXTENSION = "extension";
    public static final String ROLLOVER = "rollover";
    public static final String SELECTED = "selected";
    public static final String DOWNLOAD = "download";
    public static final String BOTH_MISSING = "both missing";
    public static final String BOTH_SELECTED_MISSING = "selected missing";
    public static final String ALL_MISSING = "all missing";
    public static final String IMAGE_MISSING = "image missing";
    public static final String ROLLVER_IMAGE_MISSING = "rollover image missing";
    public static final String SELECTED_IMAGE_MISSING = "selected image missing";
    public static final String ROLLOVER_SELECTED_IMAGE_MISSING = "rollover selected image missing";
    public static final String DIMENSION = "dimension";

    private static ButtonFactoryConfigurator instance;

    private ButtonFactoryConfigurator() {}

    public static ButtonFactoryConfigurator getInstance() {
        if(instance == null) {
            instance = new ButtonFactoryConfigurator();
        } return instance;
    }

    @Override
    public void configure(@NotNull Map<String, Object> map) {
        // EXTENSION
        if(map.containsKey(EXTENSION)) {
            if(map.get(EXTENSION) instanceof String extension) {
                ButtonFactory.extension = extension;
            } else {
                throw new IllegalArgumentException("Invalid extension object type");
            }
        } else {
            throw new IllegalArgumentException(EXTENSION + " key not found in: " + map);
        }

        // ROLLOVER
        if(map.containsKey(ROLLOVER)) {
            if(map.get(ROLLOVER) instanceof String rollover) {
                ButtonFactory.rollover = rollover;
            } else {
                throw new IllegalArgumentException("Invalid rollover object type");
            }
        } else {
            throw new IllegalArgumentException(ROLLOVER + " key not found in: " + map);
        }

        // SELECTED
        if(map.containsKey(SELECTED)) {
            if(map.get(SELECTED) instanceof String selected) {
                ButtonFactory.selected = selected;
            } else {
                throw new IllegalArgumentException("Invalid selected object type");
            }
        } else {
            throw new IllegalArgumentException(SELECTED + " key not found in: " + map);
        }

        // DOWNLOAD
        if(map.containsKey(DOWNLOAD)) {
            if(map.get(DOWNLOAD) instanceof Boolean download) {
                ButtonFactory.download = download;
            } else {
                throw new IllegalArgumentException("Invalid download object type");
            }
        } else {
            throw new IllegalArgumentException(DOWNLOAD + " key not found in: " + map);
        }

        // BOTH MISSING
        if(map.containsKey(BOTH_MISSING)) {
            if(map.get(BOTH_MISSING) instanceof String bothMissing) {
                ButtonFactory.bothMissing = Constant.valueOf(bothMissing);
            } else {
                throw new IllegalArgumentException("Invalid both missing object type");
            }
        } else {
            throw new IllegalArgumentException(BOTH_MISSING + " key not found in: " + map);
        }

        // BOTH SELECTED MISSING
        if(map.containsKey(BOTH_SELECTED_MISSING)) {
            if(map.get(BOTH_SELECTED_MISSING) instanceof String bothSelectedMissing) {
                ButtonFactory.bothSelectedMissing = Constant.valueOf(bothSelectedMissing);
            } else {
                throw new IllegalArgumentException("Invalid both missing object type");
            }
        } else {
            throw new IllegalArgumentException(BOTH_SELECTED_MISSING + " key not found in: " + map);
        }

        // ALL MISSING
        if(map.containsKey(ALL_MISSING)) {
            if(map.get(ALL_MISSING) instanceof String allMissing) {
                ButtonFactory.allMissing = Constant.valueOf(allMissing);
            } else {
                throw new IllegalArgumentException("Invalid both missing object type");
            }
        } else {
            throw new IllegalArgumentException(ALL_MISSING + " key not found in: " + map);
        }
    }
}
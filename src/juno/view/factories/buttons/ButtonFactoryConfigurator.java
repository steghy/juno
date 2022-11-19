package juno.view.factories.buttons;

import juno.model.data.io.input.Configurable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ButtonFactoryConfigurator implements Configurable {

    public static final String EXTENSION = "extension";
    public static final String ROLLOVER = "rollover";
    public static final String SELECTED = "selected";
    public static final String DOWNLOAD = "download";

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
    }
}

package juno.view.pages.options.menuPanel;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;

import java.awt.*;

public class ToggleSwitchMusic extends ImageButton {

    private static ToggleSwitchMusic instance;

    private ToggleSwitchMusic() {
        initialize();
    }

    public static ToggleSwitchMusic getInstance() {
        if(instance == null) {
            instance = new ToggleSwitchMusic();
        } return instance;
    }

    private void initialize() {
        ImageComponentInitializer.initialize(
                this,
                Directories.BUTTONS,
                "Options button",
                "options-button.png",
                "options-button-rollover.png",
                new Dimension(600, 300),
                Constant.BLUE_BUTTON,
                Constant.KEEP_ROLLOVER_IMAGE,
                Constant.KEEP_IMAGE
        );

        this.addActionListener(null);
    }
}
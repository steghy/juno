package juno.view.pages.main.menuPanel;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;

import java.awt.*;

public class OptionsButton extends ImageButton {

    private static OptionsButton instance;

    private OptionsButton() {
        initialize();
    }

    public static OptionsButton getInstance() {
        if(instance == null) {
            instance = new OptionsButton();
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
                Constant.KEEP_ROLLOVER_ICON,
                Constant.KEEP_ICON
        );

        this.addActionListener(null);
    }
}
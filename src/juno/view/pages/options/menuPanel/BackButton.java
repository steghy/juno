package juno.view.pages.options.menuPanel;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;

import java.awt.*;

public class BackButton extends ImageButton {

    public BackButton() {
        initialize();
    }

    private void initialize() {
        ImageComponentInitializer.initialize(
                this,
                Directories.BUTTONS,
                "Exit button",
                "back-button.png",
                "back-button-rollover.png",
                new Dimension(600, 300),
                Constant.BLUE_BUTTON,
                Constant.KEEP_ROLLOVER_IMAGE,
                Constant.KEEP_IMAGE
        );
    }
}
package juno.view.pages.main.menuPanel;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;

import java.awt.*;

public class ExitButton extends ImageButton {

    private static ExitButton instance;

    private ExitButton() {
        initialize();
    }

    public static ExitButton getInstance() {
        if(instance == null) {
            instance = new ExitButton();
        } return instance;
    }

    private void initialize() {
        ImageComponentInitializer.initialize(
                this,
                Directories.BUTTONS,
                "Exit button",
                "exit-button.png",
                "exit-button-rollover.png",
                new Dimension(600, 300),
                Constant.BLUE_BUTTON,
                Constant.KEEP_ROLLOVER_IMAGE,
                Constant.KEEP_IMAGE
        );

        addActionListener(listener -> {
            System.exit(0);
        });
    }
}
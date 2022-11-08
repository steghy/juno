package juno.view.logo;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;

import java.awt.*;

public class Logo extends ImageButton {

    private static Logo instance;

    private Logo() {
        initialize();
    }

    public static Logo getInstance() {
        if(instance == null) {
            instance = new Logo();
        } return instance;
    }

    private void initialize() {
        ImageComponentInitializer.initialize(
                this,
                Directories.LOGOS,
                "Uno logo",
                "logo.png",
                "logo-rollover.png",
                new Dimension(300, 300),
                Constant.BLUE_BUTTON,
                Constant.KEEP_ROLLOVER_ICON,
                Constant.KEEP_ICON
        );
    }
}

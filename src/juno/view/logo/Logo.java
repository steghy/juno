package juno.view.logo;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;

import java.awt.*;

public class Logo extends ImageButton {

    public Logo() {
        init();
    }

    private void init() {
        ImageComponentInitializer.initialize(
                this,
                Directories.LOGOS,
                "Uno logo",
                "logo.png",
                "logo-rollover.png",
                new Dimension(300, 300),
                Constant.BLUE_BUTTON,
                Constant.KEEP_ROLLOVER_IMAGE,
                Constant.KEEP_IMAGE
        );
    }
}

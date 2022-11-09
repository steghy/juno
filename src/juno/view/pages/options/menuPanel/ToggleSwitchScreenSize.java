package juno.view.pages.options.menuPanel;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageComponentInitializer;
import juno.view.util.ImageToggleButton;
import juno.view.frame.Frame;

import java.awt.*;

public class ToggleSwitchScreenSize extends ImageToggleButton {


    private static ToggleSwitchScreenSize instance;

    private ToggleSwitchScreenSize() {
        initialize();
    }

    public static ToggleSwitchScreenSize getInstance() {
       if(instance == null) {
           instance = new ToggleSwitchScreenSize();
       } return instance;
    }

    private void initialize() {
        ImageComponentInitializer.initialize(
                this,
                Directories.BUTTONS,
                "Toggle switch [screen dimension]",
                "maximize-screen.png",
                "maximize-screen-rollover.png",
                "minimize-screen.png",
                "minimize-screen-rollover.png",
                new Dimension(600, 300),

                // BOTH MISSING
                Constant.THROW_EXCEPTION,
                // BOTH SELECTED MISSING
                Constant.THROW_EXCEPTION,

                // ALL MISSING
                Constant.THROW_EXCEPTION,

                // IMAGE/ROLLOVER IMAGE MISSING
                Constant.KEEP_IMAGE,
                Constant.KEEP_ROLLOVER_IMAGE,

                // SELECTED IMAGE/ ROLLOVER SELECTED IMAGE MISSING
                Constant.KEEP_ROLLOVER_SELECTED_IMAGE,
                Constant.KEEP_SELECTED_IMAGE
        );

        Frame frame = Frame.getInstance();
        if(frame.isFullScreen()){
            doClick();
        }

        addActionListener(listener -> {
            if(isSelected()) {
                Frame.device.setFullScreenWindow(Frame.getInstance());
            } else {
                Frame.device.setFullScreenWindow(null);
            }
        });

    }
}

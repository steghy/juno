package juno.view.pages.main.menuPanel;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;

import java.awt.*;

public class ScoreButton extends ImageButton {

    private static ScoreButton instance;

    public ScoreButton() {
        initialize();
    }

    public static ScoreButton getInstance() {
        if(instance == null) {
            instance = new ScoreButton();
        } return instance;
    }

    private void initialize() {
        ImageComponentInitializer.initialize(
                this,
                Directories.BUTTONS,
                "Score button",
                "score-button.png",
                "score-button-rollover.png",
                new Dimension(600, 300),
                Constant.BLUE_BUTTON,
                Constant.KEEP_ROLLOVER_ICON,
                Constant.KEEP_ICON
        );

        this.addActionListener(null);
    }
}
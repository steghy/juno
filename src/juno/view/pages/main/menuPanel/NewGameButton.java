package juno.view.pages.main.menuPanel;

import juno.init.Directories;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;

import java.awt.*;

public class NewGameButton extends ImageButton {

    private static NewGameButton instance;

    private NewGameButton() {
        initialize();
    }

    public static NewGameButton getInstance() {
       if(instance == null) {
           instance = new NewGameButton();
       } return instance;
    }

    private void initialize() {
        ImageComponentInitializer.initialize(
                this,
                Directories.BUTTONS,
                "New game button",
                "new-game-buttonz.png",
                "new-game-button-rollover.png",
                new Dimension(600, 300),
                Constant.THROW_EXCEPTION,
                Constant.KEEP_ROLLOVER_ICON,
                Constant.KEEP_ICON
        );

        this.addActionListener(null);
    }
}

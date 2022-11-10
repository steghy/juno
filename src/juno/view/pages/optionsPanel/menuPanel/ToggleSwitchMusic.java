package juno.view.pages.optionsPanel.menuPanel;

import juno.view.util.ImageToggleButton;

public class ToggleSwitchMusic extends ImageToggleButton {

    private static ToggleSwitchMusic instance;

    private ToggleSwitchMusic() {}

    public static ToggleSwitchMusic getInstance() {
        if(instance == null) {
            instance = new ToggleSwitchMusic();
        } return instance;
    }
}

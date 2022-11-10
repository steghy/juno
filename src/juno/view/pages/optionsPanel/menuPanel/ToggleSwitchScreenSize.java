package juno.view.pages.optionsPanel.menuPanel;

import juno.view.util.ImageToggleButton;

public class ToggleSwitchScreenSize extends ImageToggleButton {

    private static ToggleSwitchScreenSize instance;

    private ToggleSwitchScreenSize() {}

    public static ToggleSwitchScreenSize getInstance() {
        if(instance == null) {
            instance = new ToggleSwitchScreenSize();
        } return instance;
    }
}

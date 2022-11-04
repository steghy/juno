package juno.view.menu.center;

import juno.init.Paths;

import javax.swing.*;

public class CenterPanelConfigurator {

    private CenterPanelConfigurator() {}

    public static void configure() {

        // MAIN-COMPONENT
        CenterPanel centerPanel = CenterPanel.getInstance();

        // BUTTONS
        JButton newGameButton = new JButton();
        JButton optionsButton = new JButton();
        JButton scoreButton = new JButton();
        JButton exitButton = new JButton();

        // IMAGES SETTINGS
        String buttonPath = Paths.BUTTONS.getPath();

        // MAIN-COMPONENT SETTING
        centerPanel.setNewGameButton(null);
        centerPanel.setOptionsButton(null);
        centerPanel.setScoreButton(null);
        centerPanel.setExitButton(null);
    }
}

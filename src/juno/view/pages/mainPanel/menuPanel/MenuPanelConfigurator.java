package juno.view.pages.mainPanel.menuPanel;

import juno.init.Directories;
import juno.init.ExitManager;
import juno.view.frame.CardPanel;
import juno.view.pages.optionsPanel.OptionsPanel;
import juno.view.util.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        AbstractButton newGameButton = new ImageButton();
        AbstractButton optionsButton = new ImageButton();
        AbstractButton scoreButton = new ImageButton();
        AbstractButton exitButton = new ImageButton();

        MenuPanel menuPanel = MenuPanel.getInstance();

        // New game button initialization
        ImageComponentInitializer.initialize(
                newGameButton,
                Directories.BUTTONS,
                "New game",
                "new-game-button.png",
                "new-game-button-rollover.png",
                new Dimension(600, 300),
                Constant.THROW_EXCEPTION,
                Constant.KEEP_ROLLOVER_IMAGE,
                Constant.KEEP_IMAGE);

        // Score button initialization
        ImageComponentInitializer.initialize(
                scoreButton,
                Directories.BUTTONS,
                "Score button",
                "score-button.png",
                "score-button-rollover.png",
                new Dimension(600, 300),
                Constant.THROW_EXCEPTION,
                Constant.KEEP_ROLLOVER_IMAGE,
                Constant.KEEP_IMAGE);

        // Options button initialization
        ImageComponentInitializer.initialize(
                optionsButton,
                Directories.BUTTONS,
                "Options",
                "options-button.png",
                "options-button-rollover.png",
                new Dimension(600, 300),
                Constant.THROW_EXCEPTION,
                Constant.KEEP_ROLLOVER_IMAGE,
                Constant.KEEP_IMAGE);

        // Exit button initialization
        ImageComponentInitializer.initialize(
                exitButton,
                Directories.BUTTONS,
                "Exit",
                "exit-button.png",
                "exit-button-rollover.png",
                new Dimension(600, 300),
                Constant.THROW_EXCEPTION,
                Constant.KEEP_ROLLOVER_IMAGE,
                Constant.KEEP_IMAGE);

        // RESIZING IMAGES
        Map<AbstractButton, Double> map = new HashMap<>();
        map.put(newGameButton, 2.0);
        map.put(optionsButton, 2.0);
        map.put(scoreButton, 2.0);
        map.put(exitButton, 2.0);
        ImageResizer.resize(map);

        // ACTION LISTENERS
        newGameButton.addActionListener(null);
        scoreButton.addActionListener(null);
        optionsButton.addActionListener(listener -> {
            CardLayout layout = (CardLayout) CardPanel.getInstance().getLayout();
            layout.show(CardPanel.getInstance(), CardPanel.OPTIONS_PANEL);
        });
        exitButton.addActionListener(listener -> {
            ExitManager.getInstance().exit();
        });

        // BORDER
        RoundedBorder border = new RoundedBorder(50, 2, null, Color.WHITE);
        menuPanel.setBorder(border);

        // ADDING COMPONENTS
        menuPanel.setNewGameButton(newGameButton);
        menuPanel.setOptionsButton(optionsButton);
        menuPanel.setScoreButton(scoreButton);
        menuPanel.setExitButton(exitButton);

        menuPanel.init();
    }

}

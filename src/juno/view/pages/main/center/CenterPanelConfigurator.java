package juno.view.pages.main.center;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.pages.main.center.CenterPanel;
import juno.view.util.ButtonConfigurator;
import juno.view.util.ImageResizer;
import juno.view.util.PanelConfigurator;

import javax.swing.*;
import java.awt.*;

public class CenterPanelConfigurator {

    private CenterPanelConfigurator() {}

    public static void configure() {
        // MAIN-COMPONENT
        CenterPanel centerPanel = CenterPanel.getInstance();

        // MAIN-COMPONENT DIMENSIONS
        PanelConfigurator.configure(centerPanel, new Dimension(300, 280));

        // BUTTONS
        JButton newGameButton = new JButton();
        JButton scoreButton = new JButton();
        JButton optionsButton = new JButton();
        JButton exitButton = new JButton();

        // BUTTONS CONFIGURATION
        ButtonConfigurator.configure(newGameButton, 300, 70);
        ButtonConfigurator.configure(scoreButton, 300, 70);
        ButtonConfigurator.configure(optionsButton, 300, 70);
        ButtonConfigurator.configure(exitButton, 100, 40);

        // BUTTONS IMAGES
        String buttonImagePath = Paths.BUTTONS.getPath();
        String newGameButtonImage = PathGenerator.generate(buttonImagePath, "new-game-button.png");
        String scoreButtonImage = PathGenerator.generate(buttonImagePath, "score-button.png");
        String optionsButtonImage = PathGenerator.generate(buttonImagePath, "options-button.png");
        String exitButtonImage = PathGenerator.generate(buttonImagePath, "exit-button.png");

        // BUTTONS IMAGES SETTINGS
        newGameButton.setIcon(new ImageIcon(ImageResizer.resize(newGameButton, newGameButtonImage)));
        scoreButton.setIcon(new ImageIcon(ImageResizer.resize(scoreButton, scoreButtonImage)));
        optionsButton.setIcon(new ImageIcon(ImageResizer.resize(optionsButton, optionsButtonImage)));
        exitButton.setIcon(new ImageIcon(ImageResizer.resize(exitButton, exitButtonImage)));

        // ACTION SETTINGS
        newGameButton.addActionListener(null);
        scoreButton.addActionListener(null);
        optionsButton.addActionListener(null);
        exitButton.addActionListener(null);

        // ACTION COMMANDS
        newGameButton.setActionCommand(null);
        scoreButton.setActionCommand(null);
        optionsButton.setActionCommand(null);
        exitButton.setActionCommand(null);

        // MAIN-COMPONENT SETTINGS
        centerPanel.setNewGameButton(newGameButton);
        centerPanel.setScoreButton(scoreButton);
        centerPanel.setOptionsButton(optionsButton);
        centerPanel.setExitButton(exitButton);

        // MAIN-COMPONENT INITIALIZATION
        centerPanel.init();
    }
}

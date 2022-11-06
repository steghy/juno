package juno.view.example.panel.center.center.menu.buttons;

import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.util.ButtonConfigurator;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanelConfigurator {

    private ButtonsPanelConfigurator() {}

    public static void configure() {
        ButtonsPanel buttonsPanel = ButtonsPanel.getInstance();
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new GridLayout(4, 1));

        JToggleButton newGameButton = new JToggleButton();
        JToggleButton scoreButton = new JToggleButton();
        JToggleButton optionsButton = new JToggleButton();
        JToggleButton exitButton = new JToggleButton();

        ButtonConfigurator.configure(newGameButton, 450,80);
        ButtonConfigurator.configure(scoreButton, 250, 65);
        ButtonConfigurator.configure(optionsButton, 250, 65);
        ButtonConfigurator.configure(exitButton, 180, 50);

        // NOT FOCUS
        String buttonsImagePath = Paths.BUTTONS.getPath();
        String newGameButtonImageNF = PathGenerator.generate(buttonsImagePath, "new-game-not-focus.png");
        String scoreButtonImageNF = PathGenerator.generate(buttonsImagePath, "score-not-focus.png");
        String optionsButtonImageNF = PathGenerator.generate(buttonsImagePath, "options-not-focus.png");
        String exitButtonImageNF = PathGenerator.generate(buttonsImagePath, "exit-not-focus.png");

        newGameButton.setIcon(new ImageIcon(ImageResizer.resize(newGameButton, newGameButtonImageNF)));
        scoreButton.setIcon(new ImageIcon(ImageResizer.resize(scoreButton, scoreButtonImageNF)));
        optionsButton.setIcon(new ImageIcon(ImageResizer.resize(optionsButton, optionsButtonImageNF)));
        exitButton.setIcon(new ImageIcon(ImageResizer.resize(exitButton, exitButtonImageNF)));

        // FOCUS
        String newGameButtonImageF = PathGenerator.generate(buttonsImagePath,"new-game-focus.png");
        String scoreButtonImageF = PathGenerator.generate(buttonsImagePath, "score-focus.png");
        String optionsButtonImageF = PathGenerator.generate(buttonsImagePath, "options-focus.png");
        String exitButtonImageF = PathGenerator.generate(buttonsImagePath, "exit-focus.png");

        newGameButton.setRolloverIcon(new ImageIcon(ImageResizer.resize(newGameButton, newGameButtonImageF)));
        scoreButton.setRolloverIcon(new ImageIcon(ImageResizer.resize(scoreButton, scoreButtonImageF)));
        optionsButton.setRolloverIcon(new ImageIcon(ImageResizer.resize(optionsButton, optionsButtonImageF)));
        exitButton.setRolloverIcon(new ImageIcon(ImageResizer.resize(exitButton, exitButtonImageF)));

        buttonsPanel.add(newGameButton, 0);
        buttonsPanel.add(scoreButton, 1);
        buttonsPanel.add(optionsButton, 2);
        buttonsPanel.add(exitButton, 3);
    }
}

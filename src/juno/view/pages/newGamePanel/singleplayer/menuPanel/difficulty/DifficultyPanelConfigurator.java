package juno.view.pages.newGamePanel.singleplayer.menuPanel.difficulty;

import juno.controller.menu.SetDifficultyAction;
import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.util.ImageResizer;

import javax.swing.*;

public class DifficultyPanelConfigurator {

    private DifficultyPanelConfigurator() {}

    public static void configure() {
        DifficultyPanel difficultyPanel = DifficultyPanel.getInstance();

        AbstractButton difficultyTitle = ButtonFactory.createButton(ButtonLibrary.DIFFICULTY_TITLE);
        AbstractButton easy = ButtonFactory.createButton(ButtonLibrary.EASY);
        AbstractButton medium = ButtonFactory.createButton(ButtonLibrary.MEDIUM);
        AbstractButton hard = ButtonFactory.createButton(ButtonLibrary.HARD);

        // RESIZE IMAGES
        ImageResizer.resize(difficultyTitle, 2.0);
        ImageResizer.resize(easy, 2.0);
        ImageResizer.resize(medium, 2.0);
        ImageResizer.resize(hard, 2.0);

        // ACTION LISTENERS
        easy.addActionListener(new SetDifficultyAction());
        medium.addActionListener(new SetDifficultyAction());
        hard.addActionListener(new SetDifficultyAction());

        // ADDING COMPONENTS
        difficultyPanel.setDifficultyTitle(difficultyTitle);
        difficultyPanel.setEasy(easy);
        difficultyPanel.setMedium(medium);
        difficultyPanel.setHard(hard);

        difficultyPanel.init();
    }
}
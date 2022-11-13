package juno.view.pages.newgame.menu.singleplayer.menu.difficulty;

import juno.controller.menu.SetDifficultyAction;
import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class DifficultyPanelConfigurator {

    private DifficultyPanelConfigurator() {}

    public static void configure() {
        DifficultyPanel difficultyPanel = DifficultyPanel.getInstance();

        AbstractButton difficultyTitle = ButtonFactory.createButton(ButtonLibrary.DIFFICULTY_TITLE);
        AbstractButton easy = ButtonFactory.createButton(ButtonLibrary.EASY);
        AbstractButton medium = ButtonFactory.createButton(ButtonLibrary.MEDIUM);
        AbstractButton hard = ButtonFactory.createButton(ButtonLibrary.HARD);

        // RESIZE IMAGES
        ImageResizer.resize(difficultyTitle, 3.0);
        ImageResizer.resize(easy, 3.0);
        ImageResizer.resize(medium, 3.0);
        ImageResizer.resize(hard, 3.0);

        // ACTION LISTENERS
        easy.addActionListener(new SetDifficultyAction());
        medium.addActionListener(new SetDifficultyAction());
        hard.addActionListener(new SetDifficultyAction());

        // BORDER
        RoundedBorder roundedBorder = new RoundedBorder(50, 2, null, Color.WHITE);
        // difficultyPanel.setBorder(roundedBorder);

        // ADDING COMPONENTS
        difficultyPanel.setDifficultyTitle(difficultyTitle);
        difficultyPanel.setEasy(easy);
        difficultyPanel.setMedium(medium);
        difficultyPanel.setHard(hard);

        difficultyPanel.init();
    }
}
package juno.view.pages.newGamePanel.singleplayer.menuPanel.difficulty;

import javax.swing.*;
import java.awt.*;

public class DifficultyPanel extends JPanel {

    private AbstractButton difficultyTitle;
    private AbstractButton easy;
    private AbstractButton medium;
    private AbstractButton hard;

    private static DifficultyPanel instance;

    private DifficultyPanel() {}

    public static DifficultyPanel getInstance() {
        if(instance == null) {
            instance = new DifficultyPanel();
        } return instance;
    }

    public void init() {
        if(difficultyTitle == null) {
            throw new IllegalArgumentException("Difficulty title is null");
        } if(easy == null) {
            throw new IllegalArgumentException("Easy is null");
        } if(medium == null) {
            throw new IllegalArgumentException("Medium is null");
        } if(hard == null) {
            throw new IllegalArgumentException("Hard is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // DIFFICULTY TITLE
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(0,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(difficultyTitle, gbc);

        // EASY BUTTON
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(easy, gbc);

        // MEDIUM BUTTON
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(medium, gbc);

        // HARD BUTTON
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,0,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(hard, gbc);
    }

    public void setDifficultyTitle(AbstractButton difficultyTitle) {
        this.difficultyTitle = difficultyTitle;
    }

    public void setEasy(AbstractButton easy) {
        this.easy = easy;
    }

    public void setMedium(AbstractButton medium) {
        this.medium = medium;
    }

    public void setHard(AbstractButton hard) {
        this.hard = hard;
    }

    public AbstractButton getDifficultyTitle() {
        return difficultyTitle;
    }

    public AbstractButton getEasy() {
        return easy;
    }

    public AbstractButton getMedium() {
        return medium;
    }

    public AbstractButton getHard() {
        return hard;
    }


}

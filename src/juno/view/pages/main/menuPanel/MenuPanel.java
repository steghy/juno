package juno.view.pages.main.menuPanel;

import juno.view.util.ImageButton;
import juno.view.util.ImageResizer;

import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;

import java.util.HashMap;
import java.util.Map;

public class MenuPanel extends JPanel {

    private static MenuPanel instance;

    private MenuPanel() {
        init();
    }

    public static MenuPanel getInstance() {
        if(instance == null) {
            instance = new MenuPanel();
        } return instance;
    }

    private void init() {
        this.setOpaque(false);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        AbstractButton newGameButton = NewGameButton.getInstance();
        AbstractButton scoreButton = ScoreButton.getInstance();
        AbstractButton optionsButton = OptionsButton.getInstance();
        AbstractButton exitButton = ExitButton.getInstance();

        Map<AbstractButton, Double> map = new HashMap<>();
        map.put(newGameButton, 2.2);
        map.put(scoreButton, 4.2);
        map.put(optionsButton, 4.2);
        map.put(exitButton, 4.2);

        ImageResizer.resize(map);

        // NEW GAME BUTTON
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(0,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(newGameButton, gbc);

        // SCORE BUTTON
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(scoreButton, gbc);

        // OPTIONS BUTTON
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(optionsButton, gbc);

        // EXIT BUTTON
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(exitButton, gbc);
    }
}

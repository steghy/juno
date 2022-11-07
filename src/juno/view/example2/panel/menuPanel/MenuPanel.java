package juno.view.example2.panel.menuPanel;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel() {
        init();
    }

    private void init() {
        this.setOpaque(false);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JButton newGameButton = new NewGameButton();
        JButton scoreButton = new ScoreButton();
        JButton optionsButton = new OptionsButton();
        JButton exitButton = new ExitButton();

        // NEW GAME BUTTON
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(10,0,10,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(newGameButton, gbc);

        // SCORE BUTTON
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(10,0,10,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(scoreButton, gbc);

        // OPTIONS BUTTON
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(10,0,10,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(optionsButton, gbc);

        // EXIT BUTTON
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(10,0,10,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(exitButton, gbc);
    }
}

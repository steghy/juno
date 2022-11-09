package juno.view.pages.main.menuPanel;

import juno.view.frame.CardPanel;
import juno.view.util.ImageButton;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

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
        this.setLayout(new GridBagLayout());


        AbstractButton newGameButton = NewGameButton.getInstance();
        AbstractButton scoreButton = ScoreButton.getInstance();
        AbstractButton optionsButton = OptionsButton.getInstance();
        AbstractButton exitButton = ExitButton.getInstance();

        optionsButton.addActionListener(listener -> {
            LayoutManager layout = CardPanel.getInstance().getLayout();
            if(layout instanceof CardLayout cardLayout) {
                cardLayout.show(CardPanel.getInstance(), "2");
            }
        });

        RoundedBorder border = new RoundedBorder(25, 1, null, Color.WHITE);
        this.setBorder(border);

        // BUTTON IMAGES RESIZE
        Map<AbstractButton, Double> map = new HashMap<>();
        map.put(newGameButton, 2.5);
        map.put(scoreButton, 2.5);
        map.put(optionsButton, 2.5);
        map.put(exitButton, 2.5);
        ImageResizer.resize(map);

        // GRID BAG LAYOUT SETTINGS
        GridBagConstraints gbc = new GridBagConstraints();

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

        gbc.insets = new Insets(17,0,0,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(exitButton, gbc);
    }
}

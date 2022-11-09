package juno.view.pages.options.menuPanel;

import juno.view.frame.CardPanel;
import juno.view.util.ImageResizer;

import javax.swing.*;
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

        GridBagConstraints gbc = new GridBagConstraints();

        AbstractButton fullScreenButton = ToggleSwitchScreenSize.getInstance();
        AbstractButton toggleSwitchMusic = ToggleSwitchMusic.getInstance();
        AbstractButton backButton = new BackButton();

        backButton.addActionListener(listener -> {
            LayoutManager layout = CardPanel.getInstance().getLayout();
            if(layout instanceof CardLayout cardLayout) {
                cardLayout.show(CardPanel.getInstance(), "1");
            }

        });

        Map<AbstractButton, Double> map = new HashMap<>();
        map.put(fullScreenButton, 2.5);
        map.put(toggleSwitchMusic, 2.5);
        map.put(backButton, 2.5);

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

        this.add(fullScreenButton, gbc);

        // OPTIONS BUTTON
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(toggleSwitchMusic, gbc);

        // EXIT BUTTON
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(backButton, gbc);
    }
}

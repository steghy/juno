package juno.view.pages.newgame.singleplayer.mode.menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private AbstractButton stackingModeButton;

    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) {
            instance = new MenuPanel();
        } return instance;
    }

    public void init() {
        if(stackingModeButton == null) {
            throw new IllegalArgumentException("Stacking mode button is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // EASY BUTTON
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.insets = new Insets(25,0,0,25);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(stackingModeButton, gbc);
    }

    public void setStackingModeButton(AbstractButton stackingModeButton) {
        this.stackingModeButton = stackingModeButton;
    }

    public AbstractButton getStackingModeButton() {
        return stackingModeButton;
    }

}

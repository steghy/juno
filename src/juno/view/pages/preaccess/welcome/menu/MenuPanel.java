package juno.view.pages.preaccess.welcome.menu;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MenuPanel
        extends JPanel {

    private AbstractButton createAnAccountButton;
    private AbstractButton continueWithoutAnAccountButton;
    private AbstractButton exitButton;
    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) instance = new MenuPanel();
        return instance;
    }

    public void init() {
        if(createAnAccountButton == null) {
            throw new IllegalArgumentException("Create an account button is null");
        } if(continueWithoutAnAccountButton == null) {
            throw new IllegalArgumentException("Continue without an account button is null");
        } if(exitButton == null) {
            throw new IllegalArgumentException("Exit button is null");
        }

        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // CREATE AN ACCOUNT BUTTON
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(0,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(createAnAccountButton, gbc);

        // CONTINUE WITHOUT AN ACCOUNT BUTTON
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(continueWithoutAnAccountButton, gbc);

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

    public void setCreateAnAccountButton(@NotNull AbstractButton createAnAccountButton) {
        this.createAnAccountButton = createAnAccountButton;
    }

    public void setContinueWithoutAnAccountButton(@NotNull AbstractButton continueWithoutAnAccountButton) {
        this.continueWithoutAnAccountButton = continueWithoutAnAccountButton;
    }

    public void setExitButton(@NotNull AbstractButton exitButton) {
        this.exitButton = exitButton;
    }
}
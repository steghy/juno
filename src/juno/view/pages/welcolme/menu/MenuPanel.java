package juno.view.pages.welcolme.menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private AbstractButton createAnAccountButton;
    private AbstractButton logInButton;
    private AbstractButton continueWithoutAnAccountButton;
    private AbstractButton exitButton;
    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) {
            instance = new MenuPanel();
        } return instance;
    }

    public void init() {
        if(createAnAccountButton == null) {
            throw new IllegalArgumentException("Create an account button is null");
        } if(logInButton == null) {
            throw new IllegalArgumentException("Log in button is null");
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

        // LOG IN BUTTON
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(logInButton, gbc);

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

    public void setCreateAnAccountButton(AbstractButton createAnAccountButton) {
        this.createAnAccountButton = createAnAccountButton;
    }

    public void setLogInButton(AbstractButton logInButton) {
        this.logInButton = logInButton;
    }

    public void setContinueWithoutAnAccountButton(AbstractButton continueWithoutAnAccountButton) {
        this.continueWithoutAnAccountButton = continueWithoutAnAccountButton;
    }

    public void setExitButton(AbstractButton exitButton) {
        this.exitButton = exitButton;
    }

    public AbstractButton getCreateAnAccountButton() {
        return createAnAccountButton;
    }

    public AbstractButton getLogInButton() {
        return logInButton;
    }

    public AbstractButton getContinueWithoutAnAccountButton() {
        return continueWithoutAnAccountButton;
    }

    public AbstractButton getExitButton() {
        return exitButton;
    }
}
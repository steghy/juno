/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.view.pages.pre_access.access.menu;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class MenuPanel
        extends JPanel {

    /* Sub components. */
    private AbstractButton createAnAccountButton;
    private AbstractButton logInButton;
    private AbstractButton continueWithoutAnAccountButton;
    private AbstractButton exitButton;

    /* The MenuPanel instance */
    private static MenuPanel instance;

    /* Builds the MenuPanel instance */
    private MenuPanel() {}

    /**
     * Returns the MenuPanel instance.
     * @return The MenuPanel instance.
     */
    public static MenuPanel getInstance() {
        if(instance == null) instance = new MenuPanel();
        return instance;
    }

    /** Initialize the MenuPanel instance
     * @throws IllegalArgumentException if one of the components
     *         of this instance has not been set.
     */
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
        gbc.gridy = 1;

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

    /**
     * Sets the 'Create an account' button.
     * @param createAnAccountButton An AbstractButton.
     */
    public void setCreateAnAccountButton(@NotNull AbstractButton createAnAccountButton) {
        this.createAnAccountButton = createAnAccountButton;
    }

    /**
     * Sets the 'Log in' button.
     * @param logInButton An AbstractButton.
     */
    public void setLogInButton(@NotNull AbstractButton logInButton) {
        this.logInButton = logInButton;
    }

    /**
     * Sets the 'Continue without an account' button.
     * @param continueWithoutAnAccountButton An AbstractButton.
     */
    public void setContinueWithoutAnAccountButton(@NotNull AbstractButton continueWithoutAnAccountButton) {
        this.continueWithoutAnAccountButton = continueWithoutAnAccountButton;
    }

    /**
     * Sets the 'Exit' button.
     * @param exitButton An AbstractButton.
     */
    public void setExitButton(@NotNull AbstractButton exitButton) {
        this.exitButton = exitButton;
    }
}
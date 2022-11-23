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

package juno.view.pages.preaccess.access.menu;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MenuPanel
        extends JPanel {

    private AbstractButton createAnAccountButton;
    private AbstractButton logInButton;
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

    public void setCreateAnAccountButton(@NotNull AbstractButton createAnAccountButton) {
        this.createAnAccountButton = createAnAccountButton;
    }

    public void setLogInButton(@NotNull AbstractButton logInButton) {
        this.logInButton = logInButton;
    }

    public void setContinueWithoutAnAccountButton(@NotNull AbstractButton continueWithoutAnAccountButton) {
        this.continueWithoutAnAccountButton = continueWithoutAnAccountButton;
    }

    public void setExitButton(@NotNull AbstractButton exitButton) {
        this.exitButton = exitButton;
    }
}
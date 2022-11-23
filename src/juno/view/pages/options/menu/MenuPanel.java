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

package juno.view.pages.options.menu;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MenuPanel
        extends JPanel {

    private AbstractButton toggleButtonMusic;
    private AbstractButton toggleButtonFullScreen;
    private AbstractButton backButton;
    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) instance = new MenuPanel();
        return instance;
    }

    public void init() {
        if(toggleButtonMusic == null) {
            throw new IllegalArgumentException("Toggle button music is null");
        } if(toggleButtonFullScreen == null) {
            throw new IllegalArgumentException("Toggle button full screen is null");
        } if(backButton == null) {
            throw new IllegalArgumentException("Back button is null");
        }

        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // TOGGLE BUTTON MUSIC
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(0,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(toggleButtonMusic, gbc);

        // TOGGLE BUTTON FULL SCREEN
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.insets = new Insets(17,0,17,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(toggleButtonFullScreen, gbc);

        // BACK BUTTON
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

    public void setToggleButtonMusic(@NotNull AbstractButton toggleButtonMusic) {
        this.toggleButtonMusic = toggleButtonMusic;
    }

    public void setToggleButtonFullScreen(@NotNull AbstractButton toggleButtonFullScreen) {
        this.toggleButtonFullScreen = toggleButtonFullScreen;
    }

    public void setBackButton(@NotNull AbstractButton backButton) {
        this.backButton = backButton;
    }
}
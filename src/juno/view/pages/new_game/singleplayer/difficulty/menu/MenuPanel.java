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

package juno.view.pages.new_game.singleplayer.difficulty.menu;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MenuPanel
        extends JPanel {

    private AbstractButton easyButton;
    private AbstractButton mediumButton;
    private AbstractButton hardButton;
    private AbstractButton backButton;

    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) instance = new MenuPanel();
        return instance;
    }

    public void init() {
        if (easyButton == null) {
            throw new IllegalArgumentException("Easy button is null");
        } if (mediumButton == null) {
            throw new IllegalArgumentException("Medium button is null");
        } if (hardButton == null) {
            throw new IllegalArgumentException("Hard button is null");
        } if (backButton == null) {
            throw new IllegalArgumentException("Back button is null");
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

        this.add(easyButton, gbc);

        // MEDIUM BUTTON
        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.insets = new Insets(0,0,0,25);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(mediumButton, gbc);

        // HARD BUTTON
        gbc.gridx = 2;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.insets = new Insets(0,0,0,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(hardButton, gbc);

        // BACK BUTTON
        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.insets = new Insets(0,0,0,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(backButton, gbc);
    }

    public void setEasyButton(@NotNull AbstractButton easyButton) {
        this.easyButton = easyButton;
    }

    public void setMedium(@NotNull AbstractButton mediumButton) {
        this.mediumButton = mediumButton;
    }

    public void setHardButton(@NotNull AbstractButton hardButton) {
        this.hardButton = hardButton;
    }

    public void setBackButton(@NotNull AbstractButton backButton) {
        this.backButton = backButton;
    }
}
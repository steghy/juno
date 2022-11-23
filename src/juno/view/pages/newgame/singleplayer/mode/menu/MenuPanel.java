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

package juno.view.pages.newgame.singleplayer.mode.menu;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MenuPanel
        extends JPanel {

    private AbstractButton stackingModeButton;

    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) instance = new MenuPanel();
        return instance;
    }

    public void init() {
        if(stackingModeButton == null) {
            throw new IllegalArgumentException("Stacking button is null");
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

    public void setStackingModeButton(@NotNull AbstractButton stackingModeButton) {
        this.stackingModeButton = stackingModeButton;
    }
}
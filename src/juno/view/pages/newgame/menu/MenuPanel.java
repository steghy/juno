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

package juno.view.pages.newgame.menu;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MenuPanel
        extends JPanel{

    private AbstractButton singlePlayer;
    private AbstractButton multiPlayer;
    private AbstractButton backButton;

    private static MenuPanel instance;
    
    private MenuPanel() {}
    
    public static MenuPanel getInstance() {
        if(instance == null) instance = new MenuPanel();
        return instance;
    }
    
    public void init() {
        if (singlePlayer == null) {
            throw new IllegalArgumentException("Single player button is null");
        } if (multiPlayer == null) {
            throw new IllegalArgumentException("Multiplayer button is null");
        } if (backButton == null) {
            throw new IllegalArgumentException("Back button is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // SINGLE PLAYER BUTTON
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(5,0,5,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(singlePlayer, gbc);

        // MULTIPLAYER BUTTON
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(5,0,5,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(multiPlayer, gbc);

        // BACK BUTTON
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(5,0,5,0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(backButton, gbc);
    }
    
    public void setSinglePlayer(@NotNull AbstractButton singlePlayer) {
        this.singlePlayer = singlePlayer;
    }

    public void setMultiPlayer(@NotNull AbstractButton multiPlayer) {
        this.multiPlayer = multiPlayer;
    }

    public void setBackButton(@NotNull AbstractButton backButton) {
        this.backButton = backButton;
    }
}
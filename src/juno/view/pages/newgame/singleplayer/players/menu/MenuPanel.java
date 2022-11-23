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

package juno.view.pages.newgame.singleplayer.players.menu;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MenuPanel
        extends JPanel {

    private AbstractButton twoPlayers;
    private AbstractButton threePlayers;
    private AbstractButton fourPlayers;
    private AbstractButton backButton;

    private static MenuPanel instance;

    private MenuPanel() {
    }

    public static MenuPanel getInstance() {
        if (instance == null) instance = new MenuPanel();
        return instance;
    }

    public void init() {
        if(twoPlayers == null) {
            throw new IllegalArgumentException("Two players button is null");
        } if(threePlayers == null) {
            throw new IllegalArgumentException("Three players button is null");
        } if(fourPlayers == null) {
            throw new IllegalArgumentException("Four players button is null");
        } if(backButton == null) {
            throw new IllegalArgumentException("Back button is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // TWO PLAYERS BUTTON
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0, 0, 0, 25);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(twoPlayers, gbc);

        // THREE PLAYERS
        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0, 0, 0, 25);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(threePlayers, gbc);

        // FOUR PLAYERS BUTTON
        gbc.gridx = 2;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0, 0, 0, 0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(fourPlayers, gbc);

        // BACK BUTTOn
        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0, 0, 0, 0);

        gbc.ipadx = 0;
        gbc.ipady = 0;

        this.add(backButton, gbc);
    }

    public void setTwoPlayers(@NotNull AbstractButton twoPlayers) {
        this.twoPlayers = twoPlayers;
    }

    public void setThreePlayers(@NotNull AbstractButton threePlayers) {
        this.threePlayers = threePlayers;
    }

    public void setFourPlayers(@NotNull AbstractButton fourPlayers) {
        this.fourPlayers = fourPlayers;
    }

    public void setBackButton(@NotNull AbstractButton backButton) {
        this.backButton = backButton;
    }
}
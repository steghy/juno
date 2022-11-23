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

package juno.view.pages.newgame.card;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class NewGameCardPanel
        extends JPanel {

    public static final String NEW_GAME_PANEL = "New game panel";
    public static final String SINGLE_PLAYER_PANEL = "Single player panel";
    public static final String MULTIPLAYER_PANEL = "Multiplayer panel";

    private JPanel newGamePanel;
    private JPanel singlePlayerPanel;
    private JPanel multiplayerPanel;

    private static NewGameCardPanel instance;

    private NewGameCardPanel() {}

    public static NewGameCardPanel getInstance() {
        if(instance == null) instance = new NewGameCardPanel();
        return instance;
    }

    public void init() {
        if (newGamePanel == null) {
            throw new IllegalArgumentException("New game panel is null");
        } if (singlePlayerPanel == null) {
            throw new IllegalArgumentException("Single player panel is null");
        } if (multiplayerPanel == null) {
            throw new IllegalArgumentException("Multiplayer panel is null");
        }

        setOpaque(false);
        setLayout(new CardLayout());
        add(newGamePanel, NEW_GAME_PANEL);
        add(singlePlayerPanel, SINGLE_PLAYER_PANEL);
        add(multiplayerPanel, MULTIPLAYER_PANEL);
    }

    public void setNewGamePanel(@NotNull JPanel newGamePanel) {
        this.newGamePanel = newGamePanel;
    }

    public void setSinglePlayerPanel(@NotNull JPanel singlePlayerPanel) {
        this.singlePlayerPanel = singlePlayerPanel;
    }

    public void setMultiplayerPanel(@NotNull JPanel multiplayerPanel) {
        this.multiplayerPanel = multiplayerPanel;
    }
}
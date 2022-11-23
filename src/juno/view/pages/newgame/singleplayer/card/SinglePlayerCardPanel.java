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

package juno.view.pages.newgame.singleplayer.card;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class SinglePlayerCardPanel
        extends JPanel {

    public static final String PLAYERS_NUMBER_PANEL = "Players number panel";
    public static final String DIFFICULTY_PANEL = "Difficulty panel";
    public static final String MODE_PANEL = "Mode panel";
    public static final String MATCH_PANEL = "Match panel";

    private JPanel playersNumberPanel;
    private JPanel difficultyPanel;
    private JPanel modePanel;
    private JPanel matchPanel;

    private static SinglePlayerCardPanel instance;

    public static SinglePlayerCardPanel getInstance() {
        if(instance == null) instance = new SinglePlayerCardPanel();
        return instance;
    }

    public void init() {
        if(playersNumberPanel == null) {
            throw new IllegalArgumentException("Players number panel is null");
        } if (difficultyPanel == null) {
            throw new IllegalArgumentException("Difficulty panel is null");
        } if (modePanel == null) {
            throw new IllegalArgumentException("Mode panel is null");
        } if (matchPanel == null) {
            throw new IllegalArgumentException("Match panel is null");
        }

        setOpaque(false);
        setLayout(new CardLayout());
        add(playersNumberPanel, PLAYERS_NUMBER_PANEL);
        add(difficultyPanel, DIFFICULTY_PANEL);
        add(modePanel, MODE_PANEL);
        add(matchPanel, MATCH_PANEL);
    }

    public void setPlayersNumberPanel(@NotNull JPanel playersNumberPanel) {
        this.playersNumberPanel = playersNumberPanel;
    }

    public void setModePanel(@NotNull JPanel modePanel) {
        this.modePanel = modePanel;
    }

    public void setMatchPanel(@NotNull JPanel matchPanel) {
        this.matchPanel = matchPanel;
    }

    public void setDifficultyPanel(@NotNull JPanel difficultyPanel) {
        this.difficultyPanel = difficultyPanel;
    }
}
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

package juno.view.pages.main.card;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MainCardPanel
        extends JPanel {

    private JPanel mainPanel;
    private JPanel optionsPanel;
    private JPanel scorePanel;
    private JPanel newGamePanel;

    public static final String MAIN_PANEL = "Main panel";
    public static final String OPTIONS_PANEL = "Options panel";
    public static final String SCORE_PANEL = "Score panel";
    public static final String NEW_GAME_PANEL = "New game panel";

    private static MainCardPanel instance;

    private MainCardPanel() {}

    public static MainCardPanel getInstance() {
        if(instance == null) instance = new MainCardPanel();
        return instance;
    }

    public void init() {
        if(mainPanel == null) {
            throw new IllegalArgumentException("Main panel is null");
        } if(optionsPanel == null) {
            throw new IllegalArgumentException("Options panel is null");
        } if(scorePanel == null) {
            throw new IllegalArgumentException("Score panel is null");
        } if(newGamePanel == null) {
            throw new IllegalArgumentException("New game panel is null");
        }

        setOpaque(false);
        setLayout(new CardLayout());
        add(mainPanel, MAIN_PANEL);
        add(optionsPanel, OPTIONS_PANEL);
        add(scorePanel, SCORE_PANEL);
        add(newGamePanel, NEW_GAME_PANEL);
    }

    public void setMainPanel(@NotNull JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setOptionsPanel(@NotNull JPanel optionsPanel) {
        this.optionsPanel = optionsPanel;
    }

    public void setScorePanel(@NotNull JPanel scorePanel) {
        this.scorePanel = scorePanel;
    }

    public void setNewGamePanel(@NotNull JPanel newGamePanel) {
        this.newGamePanel = newGamePanel;
    }
}
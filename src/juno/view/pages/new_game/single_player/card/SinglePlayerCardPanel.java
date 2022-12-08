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

package juno.view.pages.new_game.single_player.card;

import juno.view.pages.AbstractFourthComponent;

import java.awt.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class SinglePlayerCardPanel
        extends AbstractFourthComponent {

    /** The 'Players number panel' key. */
    public static final String PLAYERS_NUMBER_PANEL = "Players number panel";

    /** The 'Difficulty panel' key. */
    public static final String DIFFICULTY_PANEL = "Difficulty panel";

    /** The 'Mode panel' key. */
    public static final String MODE_PANEL = "Mode panel";

    /** The 'Match panel' key. */
    public static final String MATCH_PANEL = "Match panel";

    // The SinglePlayerCardPanel instance.
    private static SinglePlayerCardPanel instance;

    // Builds SinglePlayerCardPanel instance.
    private SinglePlayerCardPanel() {}

    /**
     * Returns the SinglePlayerCardPanel instance.
     * @return The SinglePlayerCardPanel instance.
     */
    public static SinglePlayerCardPanel getInstance() {
        if(instance == null) instance = new SinglePlayerCardPanel();
        return instance;
    }

    /** Initialize the SinglePlayerCardPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new CardLayout());
        add(Objects.requireNonNull(getFirstComponent()), PLAYERS_NUMBER_PANEL);
        add(Objects.requireNonNull(getSecondComponent()), DIFFICULTY_PANEL);
        add(Objects.requireNonNull(getThirdComponent()), MODE_PANEL);
        add(Objects.requireNonNull(getFourthComponent()), MATCH_PANEL);
    }

}
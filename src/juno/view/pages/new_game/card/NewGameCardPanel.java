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

package juno.view.pages.new_game.card;

import juno.view.panels.AbstractThirdComponent;

import java.awt.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class NewGameCardPanel
        extends AbstractThirdComponent {

    /** The 'New game panel' key */
    public static final String NEW_GAME_PANEL = "New game panel";

    /** The 'Single player panel' key */
    public static final String SINGLE_PLAYER_PANEL = "Single player panel";

    /** The 'Multiplayer panel' key */
    public static final String MULTIPLAYER_PANEL = "Multiplayer panel";

    // The NewGameCardPanel instance.
    private static NewGameCardPanel instance;

    // Builds the NewGameCardPanel instance.
    private NewGameCardPanel() {}

    /**
     * Returns the NewGameCardPanel instance.
     * @return The NewGameCardPanel instance.
     */
    public static NewGameCardPanel getInstance() {
        if(instance == null) instance = new NewGameCardPanel();
        return instance;
    }

    /** Initialize the NewGameCardPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new CardLayout());
        add(Objects.requireNonNull(getFirstComponent()), NEW_GAME_PANEL);
        add(Objects.requireNonNull(getSecondComponent()), SINGLE_PLAYER_PANEL);
        add(Objects.requireNonNull(getThirdComponent()), MULTIPLAYER_PANEL);
    }

}
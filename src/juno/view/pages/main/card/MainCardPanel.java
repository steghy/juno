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

import juno.view.panels.AbstractFourthComponent;
import java.awt.*;
import java.util.Objects;

public class MainCardPanel
        extends AbstractFourthComponent {

    /** The 'Main panel' key. */
    public static final String MAIN_PANEL = "Main panel";

    /** The 'Options panel' key. */
    public static final String OPTIONS_PANEL = "Options panel";

    /** The 'Score panel' key. */
    public static final String SCORE_PANEL = "Score panel";

    /** The 'New game panel' key. */
    public static final String NEW_GAME_PANEL = "New game panel";

    // The MainCardPanel instance.
    private static MainCardPanel instance;

    // Builds the MainCardPanel instance.
    private MainCardPanel() {}

    /**
     * Returns the MainCardPanel instance.
     * @return The MainCardPanel instance.
     */
    public static MainCardPanel getInstance() {
        if(instance == null) instance = new MainCardPanel();
        return instance;
    }

    /** Initialize the MainCardPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new CardLayout());
        add(Objects.requireNonNull(getFirstComponent()), MAIN_PANEL);
        add(Objects.requireNonNull(getSecondComponent()), OPTIONS_PANEL);
        add(Objects.requireNonNull(getThirdComponent()), SCORE_PANEL);
        add(Objects.requireNonNull(getFourthComponent()), NEW_GAME_PANEL);
    }

}
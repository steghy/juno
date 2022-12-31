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

package juno.view.pages.card;

import juno.view.panels.AbstractSecondComponent;

import java.awt.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class TopCardPanel
        extends AbstractSecondComponent {

    /** The 'Pre access panel' key. */
    public static final String PRE_ACCESS_PANEL = "Pre access panel";
    /** The 'Main panel' key. */
    public static final String MAIN_PANEL = "Main panel";

    // The TopCardPanel instance.
    private static TopCardPanel instance;

    // Builds the TopCardPanel instance.
    private TopCardPanel() {}

    /**
     * Returns the TopCardPanel instance.
     * @return The TopCardPanel instance.
     */
    public static TopCardPanel getInstance() {
        if(instance == null) instance = new TopCardPanel();
        return instance;
    }

    /** Initialize the TopCardPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new CardLayout());
        add(Objects.requireNonNull(getFirstComponent()), PRE_ACCESS_PANEL);
        add(Objects.requireNonNull(getSecondComponent()), MAIN_PANEL);
    }

}
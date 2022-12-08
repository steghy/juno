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

package juno.view.pages.pre_access.card;

import juno.view.pages.AbstractFourthComponent;

import java.awt.*;
import java.util.Objects;

public class PreAccessCardPanel
        extends AbstractFourthComponent {

    public static final String WELCOME_PANEL = "Welcome panel";
    public static final String ACCESS_PANEL = "Access panel";
    public static final String REGISTRATION_PANEL = "Registration panel";
    public static final String LOG_IN_PANEL = "Log in panel";

    // The PreAccessCardPanel instance.
    private static PreAccessCardPanel instance;

    // Builds the PreAccessCardPanel instance.
    private PreAccessCardPanel() {}

    /**
     * Returns the PreAccessCardPanel instance.
     * @return The PreAccessCardPanel instance.
     */
    public static PreAccessCardPanel getInstance() {
        if(instance == null) instance = new PreAccessCardPanel();
        return instance;
    }

    /** Initialize the PreAccessCardPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new CardLayout());
        add(Objects.requireNonNull(getFirstComponent()), WELCOME_PANEL);
        add(Objects.requireNonNull(getSecondComponent()), ACCESS_PANEL);
        add(Objects.requireNonNull(getThirdComponent()), REGISTRATION_PANEL);
        add(Objects.requireNonNull(getFourthComponent()), LOG_IN_PANEL);
    }

}
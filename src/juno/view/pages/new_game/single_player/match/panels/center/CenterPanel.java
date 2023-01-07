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

package juno.view.pages.new_game.single_player.match.panels.center;

import juno.view.panels.AbstractSeventhComponent;

import java.awt.*;
import java.util.Objects;

/**
 * This class defines the center panel.
 * @author Simone Gentili
 */
public class CenterPanel
        extends AbstractSeventhComponent {

    // The CenterPanel instance.
    private static CenterPanel instance;

    // Builds the CenterPanel instance.
    private CenterPanel() {}

    /**
     * Returns the CenterPanel instance.
     * @return The CenterPanel instance.
     */
    public static CenterPanel getInstance() {
        if(instance == null) instance = new CenterPanel();
        return instance;
    }

    /** Initialize the CenterPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Circle label.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,15,120);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(Objects.requireNonNull(getFirstComponent()), gbc);

        // Actual color panel.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,120,15,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(Objects.requireNonNull(getFourthComponent()), gbc);

        // Deck.
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,15,120);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(Objects.requireNonNull(getSecondComponent()), gbc);

        // Discarded pile
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,120,15,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(Objects.requireNonNull(getThirdComponent()), gbc);

        // Colors panel.
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,10,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(Objects.requireNonNull(getFifthComponent()), gbc);

        // Exit button.
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,100,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(Objects.requireNonNull(getSixthComponent()), gbc);

        // Uno button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,100);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(Objects.requireNonNull(getSeventhComponent()), gbc);
    }

}
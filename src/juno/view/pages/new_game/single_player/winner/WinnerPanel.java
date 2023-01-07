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

package juno.view.pages.new_game.single_player.winner;

import juno.view.panels.AbstractFourthComponent;

import java.awt.*;
import java.util.Objects;

/**
 * This class defines a winner panel.
 * @author Simone Gentili
 */
public class WinnerPanel
        extends AbstractFourthComponent {

    // The WinnerPanel instance.
    private static WinnerPanel instance;

    // Builds the WinnerPanel instance.
    private WinnerPanel() {}

    /**
     * Returns the WinnerPanel instance.
     * @return The WinnerPanel instance.
     */
    public static WinnerPanel getInstance() {
        if(instance == null) instance = new WinnerPanel();
        return instance;
    }

    /** Initialize the WinnerPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // The winner is button.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 30, 0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        this.add(Objects.requireNonNull(getFirstComponent()), gbc);

        // Avatar panel.
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 30, 0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        this.add(Objects.requireNonNull(getSecondComponent()), gbc);

        // Exit button.
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 30, 0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        this.add(Objects.requireNonNull(getThirdComponent()), gbc);

        // Exit button.
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        this.add(Objects.requireNonNull(getFourthComponent()), gbc);
    }

}
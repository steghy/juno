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
package juno.view.pages.new_game.single_player.mode.menu;

import juno.view.panels.AbstractThirdComponent;

import java.awt.*;
import java.util.Objects;

/**
 * This class defines a menu panel
 * @author Simone Gentili
 */
public class MenuPanel
        extends AbstractThirdComponent {

    // The MenuPanel instance.
    private static MenuPanel instance;

    // Builds the MenuPanel instance.
    private MenuPanel() {}

    /**
     * Returns the MenuPanel instance.
     * @return The MenuPanel instance.
     */
    public static MenuPanel getInstance() {
        if(instance == null) instance = new MenuPanel();
        return instance;
    }

    /** Initialize the MenuPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Classic mode button.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(0,0,30,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(Objects.requireNonNull(getFirstComponent()), gbc);

        // Classic mode artwork.
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(0,0,30,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(Objects.requireNonNull(getSecondComponent()), gbc);

        // Back button.
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(Objects.requireNonNull(getThirdComponent()), gbc);
    }

}
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

package juno.view.pages.new_game.single_player.match.panels.center.colors;

import juno.controller.log_out.Restorable;
import juno.controller.new_game.Mover;
import juno.model.util.Observer;
import juno.view.panels.AbstractFourthComponent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class ColorsPanel
        extends
        AbstractFourthComponent
        implements
        Observer,
        Restorable {

    // The ColorsPanel instance.
    private static ColorsPanel instance;

    // Builds the ColorsPanel instance.
    private ColorsPanel() {}

    /**
     * Returns the ColorsPanel instance.
     * @return The ColorsPanel instance.
     */
    public static ColorsPanel getInstance() {
        if(instance == null) instance = new ColorsPanel();
        return instance;
    }

    /** Initialize the ColorsPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Red color.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(Objects.requireNonNull(getFirstComponent()), gbc);

        // Blue color.
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(Objects.requireNonNull(getSecondComponent()), gbc);

        // Yellow color.
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(Objects.requireNonNull(getThirdComponent()), gbc);

        // Green color.
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(Objects.requireNonNull(getFourthComponent()), gbc);
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof Mover)
            java.util.List.of(getComponents()).forEach(c -> setEnabled(false));
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". Mover type expected.");
    }

    @Override
    public void restore() {
        java.util.List.of(getComponents()).forEach(c -> setEnabled(false));
    }

}
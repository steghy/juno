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

package juno.view.pages.new_game.single_player.match.panels.center.circle;

import juno.controller.util.InterfaceInitializer;
import juno.model.subjects.shift.InterfaceInverter;
import juno.model.util.Observer;
import juno.view.panels.AbstractSecondComponent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class CirclePanel
        extends AbstractSecondComponent
        implements Observer {

    // The inverted boolean value.
    private boolean inverted;

    // The CircleLabel instance.
    private static CirclePanel instance;

    // Builds the CircleLabel instance.
    private CirclePanel() {
        inverted = false;
    }

    /**
     * Returns the CircleLabel instance.
     * @return The CircleLabel instance.
     */
    public static CirclePanel getInstance() {
        if(instance == null) instance = new CirclePanel();
        return instance;
    }

    public void init() {
        setOpaque(false);
        setLayout(new BorderLayout());
        Objects.requireNonNull(getFirstComponent());
        Objects.requireNonNull(getSecondComponent());
        add(getFirstComponent());
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceInverter) {
            removeAll();
            if(inverted) {
                add(getFirstComponent());
                inverted = false;
            } else {
                add(getSecondComponent());
                inverted = true;
            }
        } else if(object instanceof InterfaceInitializer) {
            removeAll();
            add(getFirstComponent());
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceInverter or InterfaceInitializer type expected.");
        revalidate();
        repaint();
    }

}
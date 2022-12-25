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

package juno.view.pages.new_game.single_player.match;

import juno.model.util.InterfaceFactory;
import juno.model.util.Observer;
import juno.view.panels.AbstractFifthComponent;

import java.awt.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class MatchPanel
        extends AbstractFifthComponent
        implements Observer {

    // The MatchPanel instance.
    private static MatchPanel instance;

    // Builds the MatchPanel instance.
    private MatchPanel() {}

    /**
     * Returns the MatchPanel instance.
     * @return The MatchPanel instance.
     */
    public static MatchPanel getInstance() {
        if(instance == null) instance = new MatchPanel();
        return instance;
    }

    /** Initialize the MatchPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new BorderLayout());
    }

    @Override
    public void update(Object object) {
        if(object instanceof InterfaceFactory<?> factory) {
            removeAll();
            add(Objects.requireNonNull(getFirstComponent()), BorderLayout.SOUTH);
            add(Objects.requireNonNull(getFifthComponent()), BorderLayout.CENTER);
            int size = factory.getObjects().size();
            if(size > 3) throw new IllegalArgumentException(
                    "Unsupported number of players.");
            if(size >= 1)
                add(Objects.requireNonNull(getThirdComponent()), BorderLayout.NORTH);
            if(size >= 2)
                add(Objects.requireNonNull(getSecondComponent()), BorderLayout.EAST);
            if(size == 3) {
                add(Objects.requireNonNull(getFourthComponent()), BorderLayout.WEST);
            }
            revalidate();
            repaint();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceFactory type expected.");
    }

}
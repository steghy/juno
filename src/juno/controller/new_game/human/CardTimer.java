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

package juno.controller.new_game.human;

import juno.controller.util.Stoppable;
import juno.model.util.AbstractObservable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class defines a card timer.
 * @author Simone Gentili
 */
public class CardTimer
        extends AbstractObservable
        implements ActionListener, Observer, Stoppable {

    // The timer
    private final Timer timer;

    // The CardTimer instance.
    private static CardTimer instance;

    // Builds the CardTimer instance.
    private CardTimer() {
        timer = new Timer(1750, this);
        timer.setRepeats(false);
    }

    /**
     * Returns the CardTimer instance.
     * @return The CardTimer instance.
     */
    public static CardTimer getInstance() {
        if(instance == null) instance = new CardTimer();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateAll();
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof DrawAction<?>)
            timer.start();
        else if(object instanceof DiscardedCardSetter<?>) {
            stop();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". DrawAction expected.");
    }

    @Override
    public void stop() {
        timer.stop();
    }

}
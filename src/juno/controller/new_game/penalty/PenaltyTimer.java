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

package juno.controller.new_game.penalty;

import juno.controller.util.Stoppable;
import juno.model.util.AbstractObservable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PenaltyTimer
        extends AbstractObservable
        implements ActionListener, Stoppable {

    // The timer.
    private final Timer timer;

    // The PenaltyTimer instance.
    private static PenaltyTimer instance;

    // Builds the PenaltyTimer instance.
    private PenaltyTimer() {
        timer = new Timer(1750, this);
        timer.setRepeats(false);
    }

    public void startTimer() {
        timer.start();
        updateAll();
    }

    public Timer getTimer() {
        return timer;
    }

    /**
     * Returns the PenaltyTimer instance.
     * @return The PenaltyTimer instance.
     */
    public static PenaltyTimer getInstance() {
        if(instance == null) instance = new PenaltyTimer();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
        updateAll();
    }

    @Override
    public void stop() {
        timer.stop();
    }

}
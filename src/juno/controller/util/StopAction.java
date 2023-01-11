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

package juno.controller.util;

import juno.model.util.AbstractObservable;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class defines a StopAction.
 * @author Simone Gentili
 */
public class StopAction
        extends AbstractObservable
        implements ActionListener {

    // The stoppable object.
    private final Stoppable stoppable;

    // The component to disable.
    private final Component c;

    /**
     * Builds a StopAction object with the
     * specified parameters.
     * @param stoppable A Stoppable object.
     * @param c A Component object.
     */
    public StopAction(@NotNull Stoppable stoppable,
                      Component c) {
        this.stoppable = stoppable;
        this.c = c;
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        if(c != null) c.setEnabled(false);
        stoppable.stop();
        updateAll();
    }

}
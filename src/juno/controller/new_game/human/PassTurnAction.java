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

import juno.controller.util.GSetterAction;
import juno.model.subjects.shift.InterfaceTurnMover;
import juno.model.util.AbstractObservable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Simone Gentili
 */
public class PassTurnAction
        extends AbstractObservable
        implements ActionListener, Observer {

    // The turn mover.
    private InterfaceTurnMover turnMover;

    // The PassTurnAction instance.
    private static PassTurnAction instance;

    // Builds the PassTurnAction instance.
    private PassTurnAction() {}

    /**
     * Returns the PassTurnAction instance.
     * @return The PassTurnAction instance.
     */
    public static PassTurnAction getInstance() {
        if(instance == null) instance = new PassTurnAction();
        return instance;
    }

    /**
     * Sets the turn mover of this object.
     * @param turnMover An InterfaceTurnMover instance.
     */
    public void setTurnMover(@NotNull InterfaceTurnMover turnMover) {
        this.turnMover = turnMover;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        turnMover.next();
        updateAll();
    }

    @Override
    public void update(Object object) {
        if(object instanceof CardTimer ||
                object instanceof GSetterAction<?>) {
            actionPerformed(null);
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". CardTimer or GSetterAction type expected.");
    }

}
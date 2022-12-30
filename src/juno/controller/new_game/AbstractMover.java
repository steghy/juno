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

package juno.controller.new_game;

import juno.model.deck.AbstractDeckUser;
import juno.model.deck.InterfaceDiscardedPile;
import juno.model.subjects.shift.InterfaceTurnMover;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractMover<T>
        extends AbstractDeckUser<T> {

    // The turn mover.
    private InterfaceTurnMover turnMover;

    // The discarded pile
    private InterfaceDiscardedPile<T> discardedPile;

    /**
     * Sets the turn mover of this object.
     * @param turnMover An InterfaceTurnMover object.
     */
    public void setTurnMover(@NotNull InterfaceTurnMover turnMover) {
        this.turnMover = turnMover;
    }

    /**
     * Sets the discarded pile of this object.
     * @param discardedPile An InterfaceDiscardedPile object.
     */
    public void setDiscardedPile(@NotNull InterfaceDiscardedPile<T> discardedPile) {
        this.discardedPile = discardedPile;
    }

    /**
     * Returns the turn mover of this object.
     * @return An InterfaceTurnMover object.
     */
    @Nullable
    public InterfaceTurnMover getTurnMover() {
        return turnMover;
    }

    /**
     * Returns the discarded pile of this object.
     * @return An InterfaceDiscardedPile object.
     */
    @Nullable
    public InterfaceDiscardedPile<T> getDiscardedPile() {
        return discardedPile;
    }

}
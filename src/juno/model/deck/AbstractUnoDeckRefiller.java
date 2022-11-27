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

package juno.model.deck;

import org.jetbrains.annotations.NotNull;

/**
 * This abstract class defines abstract cards re-inserters
 * of the game 'Uno card game'. The abstract class of the
 * discard pile is also encapsulated to help you code concrete
 * classes.
 * @author Simone Gentili
 * @param <T> The type of the items.
 */
public abstract class AbstractUnoDeckRefiller<T> {

    /* The AbstractUnoDiscardedPile object */
    private AbstractUnoDiscardedPile<T> discardedPile;

    /**
     * Sets the AbstractUnoDiscardedPile object.
     * @param discardedPile An AbstractUnoDiscardedPile object.
     */
    public void setDiscardedPile(@NotNull AbstractUnoDiscardedPile<T> discardedPile) {
        this.discardedPile = discardedPile;
    }

    /**
     * Returns the AbstractUnoDiscardedPile object.
     * @return An AbstractUnoDiscardedPile object.
     */
    public AbstractUnoDiscardedPile<T> getDiscardedPile() {
        return discardedPile;
    }
}
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

import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

/**
 * @author Simone Gentili
 * @param <T> The type of the items.
 */
public class DiscardedPile<T>
        extends AbstractDiscardedPile<T>
        implements InterfaceDiscardedPile<T>, InterfaceLastItemSupplier<T>, InterfaceInspectableDeck<T> {

    /* The Stack of T items */
    private final Stack<T> discardedPile;

    /* Builds the DiscardedPile instance */
    public DiscardedPile() {
        discardedPile = new Stack<>();
    }

    @Override
    public void discard(@NotNull T card) throws IncompatibleItemException {
        if(discardedPile.isEmpty()) {
            discardedPile.push(card);
        } else {
            if(this.getCompatibilityChecker().areCompatible(discardedPile.peek(), card)) {
                discardedPile.push(card);
                updateAll();
            } else {
                throw new IncompatibleItemException(
                        "Incompatible card: " +
                        discardedPile.peek() + ", " + card);
            }
        }
    }

    @Override
    public Collection<T> items() {
        return new ArrayList<>(discardedPile);
    }

    @Override
    public T lastItem() {
        return discardedPile.peek();
    }
}
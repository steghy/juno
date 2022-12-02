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

import juno.model.card.InterfaceCard;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * This class defines the discard pile in the
 * 'Uno' game. Using the 'discard(el)' method
 * it is possible to discard a card to the top
 * of the discarded cards. All observers are
 * notified whenever the 'discard(el)' method
 * is invoked.
 * @author Simone Gentili
 */
public class DiscardedPile
        extends Stack<InterfaceCard>
        implements InterfaceDiscardedPile<InterfaceCard>, Observable {

    /* The Observers List */
    private final List<Observer> observerList;

    /* The DiscardedPile instance. */
    private static DiscardedPile instance;

    /* Builds the DiscardedPile instance. */
    private DiscardedPile() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the DiscardedPile instance.
     * @return The DiscardedPile instance.
     */
    public static DiscardedPile getInstance() {
        if(instance == null) instance = new DiscardedPile();
        return instance;
    }

    @Override
    public void discard(@NotNull InterfaceCard card) {
        push(card);
        updateAll();
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

}
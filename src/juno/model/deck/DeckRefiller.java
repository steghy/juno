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

/**
 * @author Simone Gentili
 * @param <T>
 */
public class DeckRefiller<T>
        extends AbstractUnoDeckRefiller<T>
        implements InterfaceDeckRefiller<T>, Observable {

    /* The Observers List */
    private final List<Observer> observerList;

    /* The DeckRefiller instance */
    private static DeckRefiller<?> instance;

    /* Builds the DeckRefiller instance */
    private DeckRefiller() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the DeckRefiller instance.
     * @return The DeckRefiller instance.
     */
    public static DeckRefiller<?> getInstance() {
        if(instance == null) instance = new DeckRefiller<>();
        return instance;
    }

    @Override
    public void refill(@NotNull List<T> deck) {
        AbstractUnoDiscardedPile<T> discardedPile = this.getDiscardedPile();
        T lastCard = discardedPile.lastItem();
        List<T> cards = discardedPile.items();
        cards.remove(cards.size() - 1);
        deck.addAll(cards);
        discardedPile.clear();

        try {
            discardedPile.discard(lastCard);
            // It can't happen.
        } catch (IncompatibleItemException e) {
            throw new RuntimeException(e);
        } updateAll();
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
        observerList.forEach(observer -> observer.update(null));

    }
}
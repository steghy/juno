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


import juno.model.util.InterfaceFactory;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * This class defines the deck for the game.
 * The deck is a stack, from which it is
 * possible to draw using the draw() method.
 * When the deck is almost empty it is
 * automatically filled with cards and shuffled.
 * The deck notifies all its observers whenever
 * a card is drawn.
 * @author Simone Gentili
 * @param <T> The type of the cards.:w
 */
public class Deck<T>
        extends AbstractDeck<T>
        implements InterfaceDeck<T>,
                    Observable, Observer {

    /* The Observers List */
    private final List<Observer> observerList;

    /* The Deck instance. */
    private static Deck<?> instance;

    /* Builds the Deck instance. */
    private Deck() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the Deck instance.
     * @return The Deck instance.
     */
    public static Deck<?> getInstance() {
        if(instance == null) instance = new Deck<>();
        return instance;
    }

    @Override
    public T draw() {
        if(empty()) throw new IllegalArgumentException("Empty deck");
        if(size() < 5) {
            Objects.requireNonNull(getFiller()).fill(this);
            Objects.requireNonNull(getMixer()).shuffle(this);
        } updateAll();
        return pop();
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

    @Override @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceFactory<?> factory) {
            addAll((Collection<? extends T>) factory.getObjects());
            Objects.requireNonNull(getMixer()).shuffle(this);
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceDeckFactory expected.");
    }

}
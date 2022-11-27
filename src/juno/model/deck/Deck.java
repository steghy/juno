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
import java.util.List;
import java.util.Stack;

/**
 * @author Simone Gentili@FunctionalInterface
 * @param <T> The type of the Cards.
 */
public class Deck<T>
        extends AbstractDeck<T>
        implements InterfaceDeck<T>, InterfaceGenerableDeck, InterfaceLastItemSupplier<T>, Observable{

    private final List<Observer> observerList;
    private final Stack<T> deck;
    private T lastCard;

    /* The Deck instance */
    private static Deck<?> instance;

    /* Builds the Deck instance */
    private Deck() {
        observerList = new ArrayList<>();
        deck = new Stack<>();
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
    public T draw() throws EmptyDeckException {
         // Case not allowed.
        if(deck.isEmpty()) {
            throw new EmptyDeckException("Deck is empty");
            // Automatic Deck fill.
        } else if(deck.size() <= 4) {
            this.getDeckRefiller().refill(deck);
            this.getMixer().shuffle(deck);
        } lastCard = deck.pop();
        updateAll(); // Observers update
        return lastCard;
    }

    @Override
    public T lastItem() {
        return lastCard;
    }

    @Override
    public void generate() {
        deck.clear();
        deck.addAll(this.getDeckFactory().getDeck());
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
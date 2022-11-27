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
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class UnoDiscardedPile<T> extends AbstractUnoDiscardedPile<T> implements Observable {

    /* The Stack of the T cards. */
    private final Stack<T> discardedPile;

    /*
    CompatibilityChecker component.
    It checks the compatibility between
    two cards according to the rules of
    the 'Uno card game'.
     */
    private InterfaceCompatibilityChecker<T> compatibilityChecker;

    private final List<Observer> observerList;

    /* The UnoDiscardedPile instance */
    private static UnoDiscardedPile<?> instance;

    /* Builds the UnoDiscardedPile instance */
    private UnoDiscardedPile() {
        discardedPile = new Stack<>();
        observerList = new ArrayList<>();
    }

    /**
     * Returns the UnoDiscardedPile instance.
     * @return The UnoDiscardedPile instance.
     */
    public static UnoDiscardedPile<?> getInstance() {
        if(instance == null) {
            instance = new UnoDiscardedPile<>();
        } return instance;
    }

    @Override
    public void clear() {
        // Remove all the cards from the Stack.
        // Useful for restoring the Stack for
        // a new game.
        discardedPile.clear();
    }


    @Override
    public void discard(@NotNull T card) {
        // If there are no cards in the Stack
        // then the game has yet to start.
        if(discardedPile.isEmpty()) {
            discardedPile.push(card);
        } else {
            // Compatibility check based on the
            // rules of the 'Uno card game'.
            if(compatibilityChecker.areCompatible(discardedPile.peek(), card)) {
                discardedPile.push(card);
                updateAll();
            } else {
                throw new IllegalArgumentException("Invalid input: " + card);
            }
        }
    }

    @Override
    public List<T> items() {
        return new ArrayList<>(discardedPile);
    }

    @Override
    public T lastItem() {
        // Returns the top card of the Stack which
        // is useful for the compatibility checking.
        return discardedPile.peek();
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

    /**
     * Sets the CompatibilityChecker object of this instance.
     * @param compatibilityChecker An InterfaceCompatibilityChecker object.
     */
    public void setCompatibilityChecker(@NotNull InterfaceCompatibilityChecker<T> compatibilityChecker) {
        this.compatibilityChecker = compatibilityChecker;
    }
}
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

package juno.model.deck.temp;

import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simone Gentili
 */
public class DeckFiller
        implements InterfaceDeckFiller, Observable, Observer {

    /* The List supplier */
    private List<Object> supplier;

    /* The parameter */
    private int parameter;

    /* The Observers List */
    private final List<Observer> observerList;

    /* The DeckFiller instance. */
    private static DeckFiller instance;

    /* Builds the DeckFiller instance. */
    private DeckFiller() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the DeckFiller instance.
     * @return The DeckFiller instance.
     */
    public static DeckFiller getInstance() {
        if(instance == null) instance = new DeckFiller();
        return instance;
    }

    /**
     * Sets the List supplier with the specified List.
     * @param supplier An Object List.
     */
    public void setSupplier(@NotNull List<Object> supplier) {
        this.supplier = supplier;
    }

    /**
     * Sets the parameter with the specified
     * parameter.
     * @param parameter A positive integer.
     */
    public void setParameter(int parameter) {
        if(parameter < 0) throw new IllegalArgumentException(
                "The parameter must be positive"
        ); this.parameter = parameter;
    }

    /**
     * Returns the parameter.
     * @return An int value.
     */
    public int getParameter() {
        return parameter;
    }

    @Override
    public void fill(@NotNull List<Object> deck) {
        int discardedPileSize = supplier.size();
        Object item = supplier.get(discardedPileSize - 1);
        supplier.remove(discardedPileSize - 1);
        deck.addAll(supplier);
        supplier.clear();
        supplier.add(item);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof List<?> deck) {
            if(deck.size() <= parameter) {
                fill((List<Object>) deck);
            }
        } else {
            throw new IllegalArgumentException(
                    "Invalid Observable type: " + object.getClass()
                    + ". InterfaceDeck expected." );
        }
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
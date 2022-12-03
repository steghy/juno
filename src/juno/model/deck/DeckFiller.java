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
import java.util.Objects;

/**
 * This class defines a card deck filler of
 * type 'InterfaceCard'. The fill method fills
 * the specified deck with cards contained
 * within the supplier deck according to the
 * rules of 'Uno'.
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class DeckFiller<T>
        extends AbstractDeckFiller<T>
        implements Observable {

    /* The Observers List */
    private final List<Observer> observerList;

    /* The DeckFiller instance. */
    private static DeckFiller<?> instance;

    /* Builds the DeckFiller instance. */
    private DeckFiller() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the DeckFiller instance.
     * @return The DeckFiller instance.
     */
    public static DeckFiller<?> getInstance() {
        if(instance == null) instance = new DeckFiller<>();
        return instance;
    }

    @Override
    public void fill(@NotNull List<T> deck) {
        List<T> supplier = getSupplier();
        int discardedPileSize = Objects.requireNonNull(supplier).size();
        T item = supplier.get(discardedPileSize - 1);
        supplier.remove(discardedPileSize - 1);
        deck.addAll(supplier);
        supplier.clear();
        supplier.add(item);
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
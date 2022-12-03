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
import java.util.Random;

/**
 * This class defines a mixer.
 * A shuffler can mix a data structure
 * that implements the List interface.
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class Mixer<T>
        implements InterfaceMixer<T>, Observable {

    /* The Observers List. */
    private final List<Observer> observerList;

    /* The Mixer instance. */
    private static Mixer<?> instance;

    /* Builds the Mixer instance. */
    private Mixer() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the Mixer instance.
     * @return The Mixer instance.
     */
    public static Mixer<?> getInstance() {
        if(instance == null) instance = new Mixer<>();
        return instance;
    }

    @Override
    public void shuffle(@NotNull List<T> items) {
        int size = items.size();
        if(size <= 1) return;
        Random random = new Random();
        for(int i = 0; i < 250; i++) {
            T topCard = items.get(size - 1);
            items.remove(size - 1);
            items.add(random.nextInt(size), topCard);
        }
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

}
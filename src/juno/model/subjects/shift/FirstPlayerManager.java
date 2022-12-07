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

package juno.model.subjects.shift;

import juno.model.subjects.players.InterfacePlayersProvider;
import juno.model.util.Donut;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simone Gentili
 * @param <T> The type of the players.
 * @param <E> The type of the cards.
 */
public class FirstPlayerManager<T, E>
        extends AbstractPlayersMaintainer<T>
        implements InterfaceFirstPlayerManager, Observable, Observer {

    // The Observers List.
    private final List<Observer> observerList;

    // The FirstPlayerManager instance.
    private static FirstPlayerManager<?, ?> instance;

    // Builds the FirstPlayerManager instance.
    private FirstPlayerManager() {
       observerList = new ArrayList<>();
    }

    /**
     * Returns the FirstPlayerManager instance.
     * @return The FirstPlayerManager instance.
     */
    public static FirstPlayerManager<?, ?> getInstance() {
        if(instance == null) instance = new FirstPlayerManager<>();
        return instance;
    }


    @Override
    public void setFirst() {}

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

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfacePlayersProvider<?> provider) {
            players = (Donut<T>) provider.getPlayers();
        } else {
            throw new IllegalArgumentException(
                    "Invalid Subject type: " + object.getClass() +
                            ". InterfacePlayersProvider expected.");
        }
    }

}
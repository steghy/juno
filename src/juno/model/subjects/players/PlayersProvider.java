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

package juno.model.subjects.players;

import juno.model.subjects.factory.InterfaceAiPlayerFactory;
import juno.model.util.Donut;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class PlayersProvider<T>
        implements InterfacePlayersProvider<T>, Observable, Observer {

    // The players.
    private Donut<T> players;

    // The Observers List.
    private final List<Observer> observerList;

    // The PlayersProvider instance.
    private static PlayersProvider<?> instance;

    // Builds the PlayersProvider instance.
    private PlayersProvider() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the PlayersProvider instance.
     * @return The PlayersProvider instance.
     */
    public static PlayersProvider<?> getInstance() {
        if(instance == null) instance = new PlayersProvider<>();
        return instance;
    }

    @Override @Nullable
    public Donut<T> getPlayers() {
        return players;
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

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceAiPlayerFactory<?> aiPlayersFactory) {
            players = new Donut<>();
            players.addAll((Collection<? extends T>) aiPlayersFactory.getAiPlayers());
            updateAll();
        } else throw new IllegalArgumentException("Invalid Subject type: " + object.getClass() +
                    ". InterfaceSubjectsFactory expected.");
    }

}
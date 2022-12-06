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

package juno.model.subjects.factory;

import juno.model.subjects.temp.InterfacePlayer;
import juno.model.subjects.temp.ai.AI;
import juno.model.subjects.temp.ai.InterfaceDifficulty;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AiPlayerFactory<T>
        extends AbstractAiPlayerFactory
        implements InterfaceAiPlayerFactory<InterfacePlayer<T>>, Observable {

    // The Observers List.
    private final List<Observer> observerList;

    // The PlayerFactory instance.
    private static AiPlayerFactory<?> instance;

    // Builds the PlayerFactory instance.
    private AiPlayerFactory() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the PlayerFactory instance.
     * @return The PlayerFactory instance.
     */
    public static AiPlayerFactory<?> getInstance() {
        if(instance == null) instance = new AiPlayerFactory<>();
        return instance;
    }

    @Override
    public List<InterfacePlayer<T>> getAiPlayers(int num,
                                                 @NotNull InterfaceDifficulty difficulty) {
        if(num < 1) throw new IllegalArgumentException("Invalid players number");
        List<InterfacePlayer<T>> players = new ArrayList<>();
        getNameFactory().getNames(num)
                .forEach(name -> players.add(new AI<>(name, difficulty)));
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

}
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

package juno.controller.new_game.controller;

import juno.model.data.score.Counter;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.ai.InterfaceAi;
import juno.model.util.Observer;
import juno.model.util.Provider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class CountersManager<T>
        implements Observer {

    // The lost games counter.
    private Counter<Integer> lostGamesCounter;

    // The games won counter.
    private Counter<Integer> gamesWonCounter;

    // The current player provider.
    @Nullable
    private Provider<InterfacePlayer<T>> provider;

    // The CountersManager instance.
    private static CountersManager<?> instance;

    // Builds the CountersManager instance.
    private CountersManager() {}

    /**
     * Returns the CountersManager instance.
     * @return The CountersManager instance.
     */
    public static CountersManager<?> getInstance() {
        if(instance == null) instance = new CountersManager<>();
        return instance;
    }

    /**
     * Sets the lost games counter of this object.
     * @param lostGamesCounter A Counter object.
     */
    public void setLostGamesCounter(@NotNull Counter<Integer> lostGamesCounter) {
        this.lostGamesCounter = lostGamesCounter;
    }

    /**
     * Sets the games won counter of this object.
     * @param gamesWonCounter A Counter object.
     */
    public void setGamesWonCounter(@NotNull Counter<Integer> gamesWonCounter) {
        this.gamesWonCounter = gamesWonCounter;
    }

    /**
     * Sets the current player provider of this object.
     * @param provider An InterfaceProvider object.
     */
    public void setProvider(@NotNull Provider<InterfacePlayer<T>> provider) {
        this.provider = provider;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof WinnerManager) {
            if(Objects.requireNonNull(provider).provide() instanceof InterfaceAi<?,?>)
                lostGamesCounter.increase();
            else gamesWonCounter.increase();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". WinnerManager type expected.");
    }

}
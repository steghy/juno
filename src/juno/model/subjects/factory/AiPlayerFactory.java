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

import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.ai.AI;
import juno.model.subjects.ai.InterfaceDifficulty;
import juno.model.subjects.ai.examiner.InterfaceExaminer;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class AiPlayerFactory<T>
        extends AbstractAiPlayerFactory<InterfacePlayer<T>>
        implements InterfaceAiPlayerGenerator<InterfaceDifficulty, T>, Observable {

    // The Observers List.
    private final List<Observer> observerList;

    // The ai players.
    private List<InterfacePlayer<T>> players;

    // The AiPlayerFactory instance.
    private static AiPlayerFactory<?> instance;

    // Builds the AiPlayerFactory instance.
    private AiPlayerFactory() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the AiPlayerFactory instance.
     * @return The AiPlayerFactory instance.
     */
    public static AiPlayerFactory<?> getInstance() {
        if(instance == null) instance = new AiPlayerFactory<>();
        return instance;
    }

    @Override
    public void generate(int num,
                         @NotNull InterfaceDifficulty difficulty,
                         @NotNull InterfaceExaminer<T> examiner) {
        if(num < 1) throw new IllegalArgumentException("Invalid players number");
        players = new ArrayList<>();
        Objects.requireNonNull(getNameFactory()).getNames(num)
                .forEach(name -> players.add(new AI<>(name, difficulty, examiner)));
        updateAll();
    }

    @Override @Nullable
    public List<InterfacePlayer<T>> getObjects() {
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
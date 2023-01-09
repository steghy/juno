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
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class defines an ai factory.
 * @author Simone Gentili
 * @param <T> The type of the cards.
 * @param <E> The type of the difficulty.
 */
public class AiFactory<T, E>
        extends AbstractAiFactory<List<InterfacePlayer<T>>, String, Integer>
        implements InterfaceAiGenerator<E>, Observable {

    // The Ai builder
    private InterfaceAiBuilder<T, E> builder;

    // The Observers List.
    private final List<Observer> observerList;

    // The ai players.
    private List<InterfacePlayer<T>> players;

    // The AiPlayerFactory instance.
    private static AiFactory<?, ?> instance;

    // Builds the AiPlayerFactory instance.
    private AiFactory() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the AiPlayerFactory instance.
     * @return The AiPlayerFactory instance.
     */
    public static AiFactory<?, ?> getInstance() {
        if(instance == null) instance = new AiFactory<>();
        return instance;
    }

    @Override
    public void generate(int num,
                         @NotNull E difficulty) {
        if(num < 1) throw new IllegalArgumentException("Invalid players number");
        players = Objects.requireNonNull(getRelativeProvider())
                .provide(num).stream().map(name -> builder.build(name, difficulty)).toList();
        updateAll();
    }

    /**
     * Sets the Ai builder of this object.
     * @param builder An InterfaceAiBuilder object.
     */
    public void setBuilder(@NotNull InterfaceAiBuilder<T, E> builder) {
        this.builder = builder;
    }

    @Override
    @Nullable
    public List<InterfacePlayer<T>> provide() {
        return players;
    }

    @Override
    public boolean addObserver(@NotNull Observer observer) {
        return observerList.add(observer);
    }

    @Override
    public boolean removeObserver(@NotNull Observer observer) {
        return observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

}
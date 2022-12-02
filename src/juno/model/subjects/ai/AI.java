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

package juno.model.subjects.ai;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class AI<T>
        extends AbstractAI<T>
        implements InterfaceAI<T> {

    /* The difficulty */
    private Difficulty difficulty;

    /* The AI name */
    private String name;

    /* The cards */
    private List<T> cards;

    /**
     * Builds an AI object with the
     * specified name and difficulty.
     * @param name A String object.
     * @param difficulty A Difficulty object.
     */
    public AI(@NotNull String name,
              @NotNull Difficulty difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    /**
     * Builds an AI object with the
     * specified Difficulty object.
     * @param difficulty A Difficulty object.
     */
    public AI(@NotNull Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Builds an AI object.
     */
    public AI() {}

    @Override
    public T makeAChoice() {
        return getExaminer().responseRelativeTo(cards, difficulty);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void addItem(@NotNull T item) {
        cards.add(item);
    }

    @Override
    public void removeItem(@NotNull T item) {
        cards.remove(item);
    }

    /**
     * Sets the difficulty of this object.
     * @param difficulty A Difficulty object.
     */
    public void setDifficulty(@NotNull Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Sets the name of this object.
     * @param name A String object.
     */
    public void setName(@NotNull String name) {
        this.name = name;
    }

    /**
     * Returns the Difficulty object of this object.
     * @return A Difficulty object.
     */
    @Nullable
    public Difficulty getDifficulty() {
        return difficulty;
    }
}
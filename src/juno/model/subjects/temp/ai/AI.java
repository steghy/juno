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

package juno.model.subjects.temp.ai;

import juno.model.subjects.temp.InterfacePlayer;
import org.jetbrains.annotations.NotNull;

/**
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class AI<T>
        extends AbstractAI<T>
        implements InterfacePlayer<T> {

    // The name.
    private String name;

    // The difficulty.
    private Difficulty difficulty;

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

    @Override
    public T move() {
        return getExaminer().responseRelativeTo(cards(), difficulty);
    }

    @Override
    public String name() {
        return name;
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
     * Returns the difficulty of this object.
     * @return A Difficulty object.
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

}
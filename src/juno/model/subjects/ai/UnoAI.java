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

import java.util.List;

public class UnoAI<T>
        extends AbstractUnoAI<T> {

    private Difficulty difficulty;
    private String name;
    private List<T> items;

    public UnoAI(@NotNull String name,
                 @NotNull Difficulty difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public UnoAI(@NotNull Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public UnoAI() {}

    @Override
    public T makeAChoice() {
        return getUnoExaminer().responseRelativeTo(items, difficulty);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void addItem(@NotNull T item) {
        items.add(item);
    }

    @Override
    public void removeItem(@NotNull T item) {
        items.remove(item);
    }

    public void setDifficulty(@NotNull Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}

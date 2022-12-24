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

import juno.model.subjects.AbstractPlayer;
import juno.model.subjects.InterfaceAdder;
import juno.model.subjects.InterfaceRemover;
import juno.model.subjects.ai.examiner.InterfaceExaminer;
import juno.model.util.InterfaceProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class AI<T>
        extends AbstractPlayer<T>
        implements InterfaceRemover<T>, InterfaceAdder<T>, InterfaceProvider<T> {

    // The latest card involved.
    private T card;

    // The examiner.
    private final InterfaceExaminer<T> examiner;

    // The name.
    private final String name;

    // The difficulty.
    private final InterfaceDifficulty difficulty;

    /**
     * Builds an AI object with the
     * specified name and difficulty.
     * @param name A String object.
     * @param difficulty A Difficulty object.
     */
    public AI(@NotNull String name,
              @NotNull InterfaceDifficulty difficulty,
              @NotNull InterfaceExaminer<T> examiner) {
        this.name = name;
        this.difficulty = difficulty;
        this.examiner = examiner;
    }

    @Override @Nullable
    public T move() {
        return examiner.responseRelativeTo(cards(), difficulty);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void add(@NotNull T card) {
        cards().add(card);
        this.card = card;
        updateAll();
    }

    @Override
    public void remove(@NotNull T card) {
        boolean result = cards().remove(card);
        if(!result) throw new IllegalArgumentException(
                "The card " + card + " is not in: " + cards());
        this.card = card;
        updateAll();
    }

    @Override @Nullable
    public T provide() {
        return card;
    }

}
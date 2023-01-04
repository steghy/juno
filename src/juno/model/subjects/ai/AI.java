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
import juno.model.subjects.ai.examiner.card_examiner.InterfaceCardExaminer;
import juno.model.subjects.ai.examiner.color_examiner.InterfaceColorExaminer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

/**
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class AI<T, E>
        extends AbstractPlayer<T>
        implements InterfaceAi<T, E> {

    // It's true if the last card involved
    // has been removed.
    private boolean hasRemoved;

    // The latest card involved.
    private T card;

    // The examiner.
    private final InterfaceCardExaminer<T> cardExaminer;

    private final InterfaceColorExaminer<E, T> colorExaminer;

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
              @NotNull InterfaceCardExaminer<T> cardExaminer,
              @NotNull InterfaceColorExaminer<E, T> colorExaminer) {
        this.name = name;
        this.difficulty = difficulty;
        this.cardExaminer = cardExaminer;
        this.colorExaminer = colorExaminer;
    }

    @Override @Nullable
    public T move() {
        return cardExaminer.responseRelativeTo(cards(), difficulty);
    }

    @Override
    public E color() {
        return colorExaminer.responseRelativeTo(cards());
    }

    @Override
    public boolean uno() {
        Random r = new Random();
        int num = r.nextInt(4);
        if(difficulty.isEasy()) {
            return num < 1;
        } if(difficulty.isMedium()) {
            return num < 2;
        } if(difficulty.isHard()) {
            return num < 3;
        } else throw new IllegalArgumentException(
                "Invalid difficulty object.");
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void add(@NotNull T card) {
        cards().add(card);
        this.card = card;
        hasRemoved = false;
        updateAll();
    }

    @Override
    public void remove(@NotNull T card) {
        boolean result = cards().remove(card);
        if(!result) throw new IllegalArgumentException(
                "The card " + card + " is not in: " + cards());
        this.card = card;
        hasRemoved = true;
        updateAll();
    }

    @Override @Nullable
    public T provide() {
        return card;
    }

    @Override
    public boolean hasRemoved() {
        return hasRemoved;
    }

}
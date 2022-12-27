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
import juno.model.subjects.ai.examiner.InterfaceCardExaminer;
import juno.model.subjects.ai.examiner.InterfaceColorExaminer;
import org.jetbrains.annotations.NotNull;

/**
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class AiBuilder<T, E>
        implements InterfaceAiBuilder<T, InterfaceDifficulty> {

    // The AI card examiner.
    private InterfaceCardExaminer<T> examiner;

    // The AI color examiner.
    private InterfaceColorExaminer<E, T> colorExaminer;

    // The AiBuilder instance.
    private static AiBuilder<?, ?> instance;

    // Builds the AiBuilder instance.
    private AiBuilder() {}

    /**
     * Returns the AiBuilder instance.
     * @return The AiBuilder instance.
     */
    public static AiBuilder<?, ?> getInstance() {
        if(instance == null) instance = new AiBuilder<>();
        return instance;
    }

    @Override
    public InterfacePlayer<T> build(@NotNull String name,
                                    @NotNull InterfaceDifficulty difficulty) {
        return new AI<>(name, difficulty, examiner, colorExaminer);
    }

    /**
     * Sets the Ai examiner of this object.
     * @param examiner An InterfaceExaminer object.
     */
    public void setExaminer(@NotNull InterfaceCardExaminer<T> examiner) {
        this.examiner = examiner;
    }

}
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

package juno.model.subjects.ai.examiner.card_examiner;

import juno.model.subjects.ai.examiner.AbstractExaminer;
import juno.model.subjects.ai.examiner.color_examiner.InterfaceExaminer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class defines a multi examiners.
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public abstract class AbstractMultiExaminer<T>
        extends AbstractExaminer<T> {

    /** Constructor. */
    public AbstractMultiExaminer() {}

    // Easy.
    private InterfaceExaminer<T> easy;

    // Medium.
    private InterfaceExaminer<T> medium;

    // Hard.
    private InterfaceExaminer<T> hard;

    /**
     * Sets the easy examiner of this object.
     * @param easy An InterfaceEasy object.
     */
    public void setEasy(@NotNull InterfaceExaminer<T> easy) {
        this.easy = easy;
    }

    /**
     * Sets the medium examiner of this object.
     * @param medium An InterfaceMedium object.
     */
    public void setMedium(@NotNull InterfaceExaminer<T> medium) {
        this.medium = medium;
    }

    /**
     * Sets the hard examiner of this object.
     * @param hard An InterfaceHard object.
     */
    public void setHard(@NotNull InterfaceExaminer<T> hard) {
        this.hard = hard;
    }

    /**
     * Returns the easy examiner of this object.
     * @return An InterfaceEasy object.
     */
    @Nullable
    public InterfaceExaminer<T> getEasyExaminer() {
        return easy;
    }

    /**
     * Returns the medium examiner of this object.
     * @return An InterfaceMedium object.
     */
    @Nullable
    public InterfaceExaminer<T> getMediumExaminer() {
        return medium;
    }

    /**
     * Returns the hard examiner of this object.
     * @return An InterfaceHard object.
     */
    @Nullable
    public InterfaceExaminer<T> getHardExaminer() {
        return hard;
    }

}
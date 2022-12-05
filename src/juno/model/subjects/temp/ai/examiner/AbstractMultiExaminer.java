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

package juno.model.subjects.temp.ai.examiner;

import org.jetbrains.annotations.NotNull;

/**
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public abstract class AbstractMultiExaminer<T>
        extends AbstractExaminer<T> {

    // Easy.
    private InterfaceEasyExaminer<T> easy;

    // Medium.
    private InterfaceMediumExaminer<T> medium;

    // Hard.
    private InterfaceHardExaminer<T> hard;

    /**
     * Sets the easy examiner of this object.
     * @param easy An InterfaceEasy object.
     */
    public void setEasy(@NotNull InterfaceEasyExaminer<T> easy) {
        this.easy = easy;
    }

    /**
     * Sets the medium examiner of this object.
     * @param medium An InterfaceMedium object.
     */
    public void setMedium(@NotNull InterfaceMediumExaminer<T> medium) {
        this.medium = medium;
    }

    /**
     * Sets the hard examiner of this object.
     * @param hard An InterfaceHard object.
     */
    public void setHard(@NotNull InterfaceHardExaminer<T> hard) {
        this.hard = hard;
    }

    /**
     * Returns the easy examiner of this object.
     * @return An InterfaceEasy object.
     */
    public InterfaceEasyExaminer<T> getEasyExaminer() {
        return easy;
    }

    /**
     * Returns the medium examiner of this object.
     * @return An InterfaceMedium object.
     */
    public InterfaceMediumExaminer<T> getMedium() {
        return medium;
    }

    /**
     * Returns the hard examiner of this object.
     * @return An InterfaceHard object.
     */
    public InterfaceHardExaminer<T> getHard() {
        return hard;
    }

}
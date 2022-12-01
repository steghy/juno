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

package juno.model.card.temp.values;

/**
 * This class defines nine objects one for each
 * numerical value of the 'Uno' card game. The
 * class implements the 'InterfaceValue' interface
 * and, with it, the methods for determining whether
 * an object of this class is a particular number.
 * @author Simone Gentili
 */
public enum Value implements InterfaceValue {

    /** The 'Zero' value. */
    ZERO,

    /** The 'One' value. */
    ONE,

    /** The 'Two' value. */
    TWO,

    /** The 'Three' value. */
    THREE,

    /** The 'Four' value. */
    FOUR,

    /** The 'Five' value. */
    FIVE,

    /** The 'Six' value. */
    SIX,

    /** The 'Seven' value. */
    SEVEN,

    /** The 'Eight' value. */
    EIGHT,

    /** The 'Nine' value. */
    NINE;

    @Override
    public boolean isEight() {
        return this.name().equals("EIGHT");
    }

    @Override
    public boolean isFive() {
        return this.name().equals("FIVE");
    }

    @Override
    public boolean isFour() {
        return this.name().equals("FOUR");
    }

    @Override
    public boolean isNine() {
        return this.name().equals("NINE");
    }

    @Override
    public boolean isOne() {
        return this.name().equals("ONE");
    }

    @Override
    public boolean isSeven() {
        return this.name().equals("SEVEN");
    }

    @Override
    public boolean isSix() {
        return this.name().equals("SIX");
    }

    @Override
    public boolean isThree() {
        return this.name().equals("THREE");
    }

    @Override
    public boolean isTwo() {
        return this.name().equals("TWO");
    }

    @Override
    public boolean isZero() {
        return this.name().equals("ZERO");
    }

}
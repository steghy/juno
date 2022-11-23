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

package juno.model.card;

public enum UnoCardValue
        implements InterfaceUnoCardValue {

    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    HEIGHT,
    NINE;

    @Override
    public boolean isValueZero() {
        return this.name().equals("ZERO");
    }

    @Override
    public boolean isValueOne() {
        return this.name().equals("ONE");
    }

    @Override
    public boolean isValueTwo() {
        return this.name().equals("TWO");
    }

    @Override
    public boolean isValueThree() {
        return this.name().equals("THREE");
    }

    @Override
    public boolean isValueFour() {
        return this.name().equals("FOUR");
    }

    @Override
    public boolean isValueFive() {
        return this.name().equals("FIVE");
    }

    @Override
    public boolean isValueSix() {
        return this.name().equals("SIX");
    }

    @Override
    public boolean isValueSeven() {
        return this.name().equals("SEVEN");
    }

    @Override
    public boolean isValueEight() {
        return this.name().equals("HEIGHT");
    }

    @Override
    public boolean isValueNine() {
        return this.name().equals("NINE");
    }
}
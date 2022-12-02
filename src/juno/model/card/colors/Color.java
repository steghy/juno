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

package juno.model.card.colors;

/**
 * This class defines four objects, one for each
 * color of the 'Uno' card game. The class implements
 * the 'InterfaceColor' interface and, with it, the
 * methods for determining whether an object of this
 * class is a particular color.
 * @author Simone Gentili
 */
public enum Color implements InterfaceColor {

    /** The 'Red' color. */
    RED,

    /** The 'Blue' color. */
    BLUE,

    /** The 'Green' color. */
    GREEN,

    /** The 'Yellow' color. */
    YELLOW;

    @Override
    public boolean isBlue() {
        return this.name().equals("BLUE");
    }

    @Override
    public boolean isGreen() {
        return this.name().equals("GREEN");
    }

    @Override
    public boolean isRed() {
        return this.name().equals("RED");
    }

    @Override
    public boolean isYellow() {
        return this.name().equals("YELLOW");
    }
}
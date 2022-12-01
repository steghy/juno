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

package juno.model.card.temp.actions;

/**
 * This class defines five objects, one for each
 * action of the 'Uno' card game. The class implements
 * the 'InterfaceAction' interface and, with it, the
 * methods for determining whether an object of this
 * class is a particular action.
 * @author Simone Gentili
 */
public enum Action implements InterfaceAction {

    /** The 'change color' action. */
    CHANGE_COLOR,

    /** The 'draw four' action. */
    DRAW_FOUR,

    /** The 'skip' action. */
    SKIP,

    /** The 'invert' action. */
    INVERT,

    /** The 'draw two' action. */
    DRAW_TWO;

    @Override
    public boolean isDrawTwo() {
        return this.name().equals("DRAW_TWO");
    }

    @Override
    public boolean isInvert() {
        return this.name().equals("INVERT");
    }

    @Override
    public boolean isSkip() {
        return this.name().equals("SKIP");
    }

    @Override
    public boolean isChangeColor() {
        return this.name().equals("CHANGE_COLOR");
    }

    @Override
    public boolean isDrawFour() {
        return this.name().equals("DRAW_FOUR");
    }

    @Override
    public boolean isJolly() {
        return isDrawFour() || isChangeColor();
    }

}
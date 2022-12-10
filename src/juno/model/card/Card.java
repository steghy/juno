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

import juno.model.card.actions.InterfaceAction;
import juno.model.card.colors.InterfaceColor;
import org.jetbrains.annotations.Nullable;

/**
 * This class defines the model of the 'Uno' card.
 * A 'Uno' card has the following attributes:
 * - Color
 * - Value
 * - Action
 * An attribute of a card can also be null, if the
 * card type does not allow it.
 *
 * @param color  The Color
 * @param value  The Value
 * @param action The Action
 * @author Simone Gentili
 */
public record Card(InterfaceColor color, Integer value, InterfaceAction action)
        implements InterfaceCard {

    /**
     * Builds a Card object with the specified
     * parameters.
     *
     * @param color  An InterfaceColor object.
     * @param value  An Integer object.
     * @param action An InterfaceAction object.
     */
    public Card {}

    @Override
    @Nullable
    public InterfaceAction action() {
        return action;
    }

    @Override
    @Nullable
    public InterfaceColor color() {
        return color;
    }

    @Override
    @Nullable
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object object){
        return this == object;
    }

}
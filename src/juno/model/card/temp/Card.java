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

package juno.model.card.temp;

import juno.model.card.temp.actions.InterfaceAction;
import juno.model.card.temp.colors.InterfaceColor;
import juno.model.card.temp.values.InterfaceValue;
import org.jetbrains.annotations.Nullable;

public class Card
        implements InterfaceCard{

    private InterfaceColor color;
    private final InterfaceValue value;
    private final InterfaceAction action;

    public Card(InterfaceColor color,
                InterfaceValue value,
                InterfaceAction action) {
        this.color = color;
        this.value = value;
        this.action = action;
    }

    @Override @Nullable
    public InterfaceAction action() {
        return action;
    }

    @Override @Nullable
    public InterfaceColor color() {
        return color;
    }

    @Override @Nullable
    public InterfaceValue value() {
        return value;
    }
}
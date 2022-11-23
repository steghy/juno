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

import org.jetbrains.annotations.NotNull;

public class UnoCardColor<T>
        implements InterfaceUnoCardColor<T> {

    private T color;

    public UnoCardColor(T color) {
       this.color = color;
    }

    @Override
    public void setUnoColor(T color) {
        this.color = color;
    }

    @Override
    public T getUnoColor(){
        return this.color;
    }

    @Override
    public boolean equals(@NotNull Object object) {
        if(object instanceof UnoCardColor<?> obj) {
            return this.color.equals(obj.getUnoColor());
        } else {
            throw new IllegalArgumentException("Invalid type "
            + object.getClass() + ", expected UnoCardColor type");
        }
    }

    @Override
    public String toString() {
        return this.color == null ? "NO_COLOR" : this.color.toString();
    }
}
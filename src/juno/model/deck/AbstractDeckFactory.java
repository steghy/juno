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

package juno.model.deck;

import org.jetbrains.annotations.NotNull;

/**
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public abstract class AbstractDeckFactory<T>
        implements InterfaceDeckFactory<T> {

    /* The InterfaceCardFactory object. */
    private InterfaceCardFactory<T> factory;

    /**
     * Sets the InterfaceCardFactory object.
     * @param factory An InterfaceCardFactory.
     */
    public void setCardFactory(@NotNull InterfaceCardFactory<T> factory){
        this.factory = factory;
    }

    /**
     * Returns the InterfaceCardFactory object.
     * @return An InterfaceCardFactory object.
     */
    public InterfaceCardFactory<T> getCardFactory(){
        return factory;
    }

}

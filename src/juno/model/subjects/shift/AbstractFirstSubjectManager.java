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

package juno.model.subjects.shift;

import juno.model.deck.InterfaceDeck;
import juno.model.subjects.hands.InterfaceHandsManager;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractFirstSubjectManager<T, E>
        implements InterfaceFirstSubjectManager {

    private InterfaceHandsManager<T, E> handsManager;
    private InterfaceDeck<E> deck;

    public void setHandsManager(@NotNull InterfaceHandsManager<T, E> handsManager) {
        this.handsManager = handsManager;
    }

    public void setDeck(@NotNull InterfaceDeck<E> deck) {
        this.deck = deck;
    }

    public InterfaceHandsManager<T, E> getHandsManager() {
        return handsManager;
    }

    public InterfaceDeck<E> getDeck() {
        return deck;
    }

}

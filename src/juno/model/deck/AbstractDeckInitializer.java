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
import org.jetbrains.annotations.Nullable;

/**
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public abstract class AbstractDeckInitializer<T> {

    // The deck factory.
    private InterfaceDeckFactory<T> factory;

    // The deck.
    private InterfaceDeck<T> deck;

    // The mixer.
    private InterfaceMixer<T> mixer;

    /**
     * Sets the deck factory of this object.
     * @param factory An InterfaceDeckFactory object.
     */
    public void setFactory(@NotNull InterfaceDeckFactory<T> factory) {
        this.factory = factory;
    }

    /**
     * Sets the deck of this object.
     * @param deck An InterfaceDeck object.
     */
    public void setDeck(@NotNull InterfaceDeck<T> deck) {
        this.deck = deck;
    }

    /**
     * Sets the mixer of this object.
     * @param mixer An InterfaceMixer object.
     */
    public void setMixer(@NotNull InterfaceMixer<T> mixer) {
        this.mixer = mixer;
    }

    /**
     * Returns the deck factory of this object.
     * @return An InterfaceDeckFactory object.
     */
    @Nullable
    public InterfaceDeckFactory<T> getFactory() {
        return factory;
    }

    /**
     * Returns the deck of this object.
     * @return An InterfaceDeck object.
     */
    @Nullable
    public InterfaceDeck<T> getDeck() {
        return deck;
    }

    /**
     * Returns the mixer of this object.
     * @return An InterfaceMixer object.
     */
    @Nullable
    public InterfaceMixer<T> getMixer() {
        return mixer;
    }

}
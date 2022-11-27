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
 * This abstract class encapsulates some utility objects
 * for a generic deck. The objects are:
 * - InterfaceDeckRefiller<T> (It might fill the deck when it's nearly empty).
 * - InterfaceDeckFactory<T> (Provides the deck of T cards).
 * - InterfaceDeckMixer<T> (Can shuffles the deck).
 * @param <T> The type of the cards.
 */
public abstract class AbstractDeck<T> {

    /* The Refiller */
    private InterfaceDeckRefiller<T> deckRefiller;

    /* The Factory */
    private InterfaceDeckFactory<T> deckFactory;

    /* The Mixer */
    private InterfaceMixer<T> deckMixer;

    /**
     * Sets the Factory that providers the deck of T cards.
     * @param deckFactory An InterfaceDeckFactory object.
     */
    public void setDeckFactory(@NotNull InterfaceDeckFactory<T> deckFactory) {
        this.deckFactory = deckFactory;
    }

    /**
     * Sets the Refiller that fill the deck.
     * @param deckRefiller An InterfaceDeckRefiller object.
     */
    public void setDeckRefiller(@NotNull InterfaceDeckRefiller<T> deckRefiller) {
        this.deckRefiller = deckRefiller;
    }

    /**
     * Sets the Mixer that can shuffle the deck.
     * @param deckMixer An InterfaceMixer object.
     */
    public void setMixer(@NotNull InterfaceMixer<T> deckMixer) {
        this.deckMixer = deckMixer;
    }

    /**
     * Returns the InterfaceDeckFactory object.
     * @return An InterfaceDeckFactory object.
     */
    public InterfaceDeckFactory<T> getDeckFactory() {
        return this.deckFactory;
    }

    /**
     * Returns the InterfaceDeckRefiller object.
     * @return An InterfaceDeckRefiller object.
     */
    public InterfaceDeckRefiller<T> getDeckRefiller() {
        return this.deckRefiller;
    }

    /**
     * Returns the InterfaceMixer object.
     * @return An InterfaceMixer object.
     */
    public InterfaceMixer<T> getMixer() {
        return this.deckMixer;
    }
}

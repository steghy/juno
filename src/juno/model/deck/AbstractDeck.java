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

import java.util.Stack;

/**
 * This abstract class defines abstract 'Decks'
 * composed of a 'Filler' for reintroducing
 * cards and a 'Mixer' for shuffling the deck.
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public abstract class AbstractDeck<T>
        extends Stack<T>
        implements InterfaceDeck<T> {

    /* The Deck filler */
    private InterfaceDeckFiller<T> filler;

    /* The Deck mixer */
    private InterfaceMixer<T> mixer;

    /**
     * Sets the Deck filler of this object.
     * @param filler An InterfaceDeckFiller object.
     */
    public void setDeckFiller(@NotNull InterfaceDeckFiller<T> filler) {
        this.filler = filler;
    }

    /**
     * Sets the Deck mixer of this object.
     * @param mixer An InterfaceMixer object.
     */
    public void setMixer(@NotNull InterfaceMixer<T> mixer) {
        this.mixer = mixer;
    }

    /**
     * Returns the Deck filler of this object.
     * @return An InterfaceDeckFiller object.
     */
    public InterfaceDeckFiller<T> getFiller() {
        return filler;
    }

    /**
     * Returns the Deck mixer of this object.
     * @return An InterfaceMixer object.
     */
    public InterfaceMixer<T> getMixer() {
        return mixer;
    }

}
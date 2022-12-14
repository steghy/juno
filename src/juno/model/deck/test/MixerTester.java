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

package juno.model.deck.test;

import juno.model.card.InterfaceCard;
import juno.model.deck.Deck;
import juno.model.deck.DeckFactory;
import juno.model.deck.Mixer;

/**
 * This class defines a mixer tester.
 * @author Simone Gentili
 */
public class MixerTester {

    // Tester class.
    private MixerTester() {}

    /**
     * Execute the mixer tester with the
     * specified arguments.
     * @param args An array of String objects.
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Mixer<InterfaceCard> mixer = (Mixer<InterfaceCard>) Mixer.getInstance();
        DeckFactory deckFactory = DeckFactory.getInstance();
        Deck<InterfaceCard> deck = (Deck<InterfaceCard>) Deck.getInstance();
        deck.addAll(deckFactory.provide());
        mixer.shuffle(deck);
        deck.forEach(System.out::println);
    }

}
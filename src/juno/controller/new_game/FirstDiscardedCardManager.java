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

package juno.controller.new_game;

import juno.model.card.InterfaceCard;
import juno.model.deck.Deck;
import juno.model.deck.DiscardedPile;
import juno.model.util.Observer;

import java.awt.event.ActionListener;

/**
 * @author Simone Gentili
 */
public class FirstDiscardedCardManager
        implements Observer {

    // The FirstDiscardedCardManager instance.
    private static FirstDiscardedCardManager instance;

    // The FirstDiscardedCardManager instance.
    private FirstDiscardedCardManager() {}

    /**
     * Returns the FirstDiscardedCardManager instance.
     * @return The FirstDiscardedCardManager instance.
     */
    public static FirstDiscardedCardManager getInstance() {
        if(instance == null) instance = new FirstDiscardedCardManager();
        return instance;
    }

    @SuppressWarnings("unchecked")
    public void discardFirstCard() {
        Deck<InterfaceCard> deck = (Deck<InterfaceCard>) Deck.getInstance();
        DiscardedPile<InterfaceCard> discardedPile = (DiscardedPile<InterfaceCard>) DiscardedPile.getInstance();
        InterfaceCard card = deck.draw();
        while(card.color() == null) {
            deck.add(0, card);
            card = deck.draw();
        } discardedPile.discard(card);
    }

    @Override
    public void update(Object object) {
        if(object instanceof ActionListener)
            discardFirstCard();
    }

}
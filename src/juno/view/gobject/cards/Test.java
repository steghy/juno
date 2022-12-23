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

package juno.view.gobject.cards;

import juno.init.initializer.ModelInitializer;
import juno.init.initializer.ViewInitializer;
import juno.model.card.InterfaceCard;
import juno.model.deck.Deck;
import juno.model.deck.DeckFactory;
import juno.view.gobject.InterfaceGObject;

import javax.swing.*;
import java.util.Map;
import java.util.Objects;


public class Test {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Initialization.
        ModelInitializer.initialize();
        ViewInitializer.initialize();

        // Deck model.
        Deck<InterfaceCard> deck = (Deck<InterfaceCard>) Deck.getInstance();
        DeckFactory deckFactory = DeckFactory.getInstance();
        deckFactory.generate();

        // Graphic deck and cards.
        GCardMapFactory gCardMapFactory = GCardMapFactory.getInstance();
        Map<InterfaceCard, InterfaceGObject<InterfaceCard>> map = gCardMapFactory.getGObjectsMap();
        InterfaceCard card = deck.draw();
        GCard<InterfaceCard> gCard = (GCard<InterfaceCard>) Objects.requireNonNull(map).get(card);

        JPanel panel;

        // JFrame.
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(gCard);
        frame.pack();
        frame.setVisible(true);
    }

}
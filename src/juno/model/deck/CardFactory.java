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

import juno.model.card.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

 class CardFactory
         implements InterfaceCardFactory<InterfaceUnoCard> {

    private static CardFactory instance;

    private CardFactory() {}

    static CardFactory getInstance(){
        if(instance == null) instance = new CardFactory();
        return instance;
    }

    @Override
    public Collection<InterfaceUnoCard> getCards() {
        List<InterfaceUnoCard> cards = new ArrayList<>();

        // COLORED CARDS
        Arrays.asList(UnoColor.values()).forEach(color -> {
            Arrays.asList(UnoCardValue.values()).forEach(value ->
                    cards.add(new UnoCard(null, new UnoCardColor<>(color), value)));

            Arrays.asList(UnoCardAction.values()).forEach(action -> {
                if(action != null) {
                    if (!action.isWildAction() && !action.isWildDrawFourAction()) {
                        cards.add(new UnoCard(action, new UnoCardColor<>(color), null));
                    }
                }
            });
        });

        // JOLLY CARDS
        cards.add(new UnoCard(UnoCardAction.WILD, null, null));
        cards.add(new UnoCard(UnoCardAction.WILD_DRAW_FOUR, null, null));
        return cards;
    }
}
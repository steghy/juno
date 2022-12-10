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

import juno.model.card.Card;
import juno.model.card.InterfaceCard;
import juno.model.card.actions.Action;
import juno.model.card.colors.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * This class provides all different types of
 * cards in the 'Uno' card game. Using the
 * simple attributes described in the enum classes
 * 'Value', 'Color' and 'Action', the method
 * 'getCards()' returns a List containing all the
 * different types of cards using the type 'Card'
 * and his interface 'InterfaceCard'.
 * @author Simone Gentili
 */
@Deprecated
 public class CardFactory
        implements InterfaceCardFactory<InterfaceCard> {

     /* The CardFactory instance. */
    private static CardFactory instance;

    /* Builds the CardFactory instance. */
    private CardFactory() {}

    /**
     * Returns the CardFactory instance.
     * @return The CardFactory instance.
     */
    public static CardFactory getInstance(){
        if(instance == null) instance = new CardFactory();
        return instance;
    }

    @Override
    public Collection<InterfaceCard> getCards() {
        List<InterfaceCard> cards = new ArrayList<>();
        Arrays.asList(Color.values()).forEach(color -> {
            // Numeric cards
            for(int i = 0; i < 10; i++) cards.add(new Card(color, i, null));
            // Action cards (Non-jolly)
            Arrays.asList(Action.values()).forEach(action -> {
                if (action != null) {
                    if (!action.isJolly()) {
                        cards.add(new Card(color, null, action));
                    }
                }
            });
        });
        // Jolly cards
        cards.add(new Card(null, null, Action.DRAW_FOUR));
        cards.add(new Card(null, null, Action.CHANGE_COLOR));
        return cards;
    }

}
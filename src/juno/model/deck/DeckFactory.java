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
import juno.model.util.InterfaceFactory;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * This class defines a factory for the 'Uno' deck.
 * The method 'getDeck()' generates a deck using the
 * cards supplied by the 'InterfaceCardFactory'
 * according to the rules of the 'Uno' game.
 * A 'Uno' deck consists of 108 cards, of which there
 * are 76 Number cards, 24 Action cards and 8 Wild cards.
 * @author Simone Gentili
 */
public class DeckFactory
        implements InterfaceFactory<InterfaceCard>,
                    InterfaceDeckGenerator, Observable {

    // The Observers List.
    private final List<Observer> observerList;

    // The deck.
    private List<InterfaceCard> deck;

    // The DeckFactory instance.
    private static DeckFactory instance;

    // Builds the DeckFactory.
    private DeckFactory() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the DeckFactory instance.
     * @return The DeckFactory instance.
     */
    public static DeckFactory getInstance(){
        if(instance == null) instance = new DeckFactory();
        return instance;
    }

    @Override @Nullable
    public List<InterfaceCard> getObjects() {
        return deck;
    }

    @Override
    public void generate() {
        deck = new ArrayList<>();
        Arrays.asList(Color.values()).forEach(color -> {
            // Numerical cards.
            for(int i = 0; i < 2; i++)
                for(int j = 1; j < 10; j++)
                    deck.add(new Card(color, j, null));

            // Zeros cards.
            deck.add(new Card(color, 0, null));

            // Actions cards.
            Arrays.asList(Action.values()).forEach(action -> {
                if(action.isJolly()) deck.add(new Card(null, null, action));
                else for(int i = 0; i < 2; i++) deck.add(new Card(color, null, action));
            });
        }); updateAll();
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

}
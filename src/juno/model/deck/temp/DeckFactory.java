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

package juno.model.deck.temp;

import juno.model.card.temp.InterfaceCard;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Simone Gentili
 */
public class DeckFactory
        extends AbstractDeckFactory<InterfaceCard>
        implements InterfaceDeckFactory<InterfaceCard>, Observable, Observer {

    /* The Observers List */
    private final List<Observer> observerList;

    /* The DeckFactory instance */
    private static DeckFactory instance;

    /* Builds the DeckFactory */
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

    @Override
    public Collection<InterfaceCard> getDeck() {
        Collection<InterfaceCard> cards = this.getFactory().getCards();
        Collection<InterfaceCard> deck = new ArrayList<>();
        cards.forEach(card -> {
            deck.add(card);
            if (card.action() != null) {
                if (card.action().isJolly()) {
                    deck.add(card); deck.add(card);
                }
            } if(card.action() != null || card.value() != null
                    && !card.value().isZero()) {
                deck.add(card);
            }
        }); return deck;
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

    @Override
    public void update(@NotNull Object object) {

    }

}
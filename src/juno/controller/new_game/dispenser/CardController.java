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

package juno.controller.new_game.dispenser;

import juno.model.card.Card;
import juno.model.card.InterfaceCard;
import juno.model.deck.InterfaceDeck;
import juno.model.deck.Mixer;
import juno.model.subjects.InterfacePlayer;
import juno.model.util.AbstractObservable;
import juno.model.util.Generator;
import juno.model.util.Provider;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Simone Gentili
 */
public class CardController
        extends AbstractObservable
        implements Observer, Provider<List<InterfacePlayer<InterfaceCard>>>, Generator {

    // The deck.
    private InterfaceDeck<InterfaceCard> deck;

    // The players.
    private final List<InterfacePlayer<InterfaceCard>> players;

    // The CardController instance.
    private static CardController instance;

    // Builds a CardController.
    private CardController() {
        players = new ArrayList<>();
    }

    /**
     * Returns the CardController instance.
     * @return The CardController instance.
     */
    public static CardController getInstance() {
        if(instance == null) instance = new CardController();
        return instance;
    }

    @Override
    public List<InterfacePlayer<InterfaceCard>> provide() {
        return players;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void generate() {
        Map<InterfaceCard, InterfacePlayer<InterfaceCard>> map =
                players.stream()
                        .collect(Collectors.toMap(Provider::provide, value -> value));
        List<Card> cards = new ArrayList<>(players.stream().map(player -> (Card) player.provide()).toList());
        players.forEach(p ->
                p.remove(p.provide()));
        players.clear();
        Collections.sort(cards);
        Collections.reverse(cards);
        Card b = cards.get(0); // The biggest card.
        deck.addAll(cards);
        players.add(map.get(b));
        cards.remove(b);
        for(Card card : cards) {
            if(b.compareTo(card) == 0)
                players.add(map.get(card));
            else break;
        }
        Mixer<InterfaceCard> mixer = (Mixer<InterfaceCard>) Mixer.getInstance();
        mixer.shuffle(deck);
        updateAll();
    }

    @Override @SuppressWarnings("unchecked")
    public void update(Object object) {
        if(object instanceof Provider<?> provider) {
            players.clear();
            players.addAll((List<InterfacePlayer<InterfaceCard>>) provider.provide());
            generate();
        } else throw new IllegalArgumentException();
    }

    /**
     * Sets the deck of this object.
     * @param deck An InterfaceDeck object.
     */
    public void setDeck(@NotNull InterfaceDeck<InterfaceCard> deck) {
        this.deck = deck;
    }

}
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
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.ai.InterfaceAi;
import juno.model.subjects.shift.PlayersProvider;
import juno.model.subjects.shift.TurnMover;
import juno.model.util.AbstractObservable;
import juno.model.util.Donut;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class Mover
        extends AbstractObservable
        implements ActionListener, Observer {

    // The timer.
    private final Timer timer;

    // The Mover instance.
    private static Mover instance;

    // Builds the Mover instance.
    private Mover() {
        timer = new Timer(1500, this);
    }

    /**
     * Returns the Mover instance.
     * @return The Mover instance.
     */
    public static Mover getInstance() {
        if(instance == null) instance = new Mover();
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {
        PlayersProvider<InterfacePlayer<InterfaceCard>> provider =
                (PlayersProvider<InterfacePlayer<InterfaceCard>>) PlayersProvider.getInstance();
        Donut<InterfacePlayer<InterfaceCard>> players = provider.provide();
        InterfacePlayer<InterfaceCard> current = Objects.requireNonNull(players).current();
        Deck<InterfaceCard> deck = (Deck<InterfaceCard>) Deck.getInstance();
        DiscardedPile<InterfaceCard> discardedPile = (DiscardedPile<InterfaceCard>) DiscardedPile.getInstance();

        // Ai case.
        if(current instanceof InterfaceAi<?, ?> ai) {
            // The chosen card.
            InterfaceCard card = (InterfaceCard) ai.move();

            // Ai hasn't cards to play.
            if(card == null) {
                current.add(deck.draw());
                card = (InterfaceCard) ai.move();
            }

            // Ai has a card to play.
            if(card != null) {
                discardedPile.discard(card);
                current.remove(card);
            } TurnMover.getInstance().next();
        } else {
            timer.stop();
            updateAll();
        }
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceCardDispenser)
            timer.start();
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceCardDispenser type expected");
    }

}
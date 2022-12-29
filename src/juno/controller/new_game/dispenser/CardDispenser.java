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

import juno.model.card.InterfaceCard;
import juno.model.deck.InterfaceDeck;
import juno.model.subjects.InterfacePlayer;
import juno.model.util.AbstractObservable;
import juno.model.util.InterfaceProvider;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Simone Gentili
 */
public class CardDispenser
        extends
        AbstractObservable
        implements
        ActionListener,
        Observer,
        InterfaceCardDispenser {

    // The deck.
    private InterfaceDeck<InterfaceCard> deck;

    // The players.
    private List<InterfacePlayer<InterfaceCard>> players;

    // The players size.
    private int size;

    // The players size copy.
    private int copy;

    // The timer.
    private final Timer timer;

    // The CardDispenser instance.
    private static CardDispenser instance;

    // Builds the CardDispenser instance.
    private CardDispenser() {
        timer = new Timer(750, this);
    }

    /**
     * Returns the CardDispenser instance.
     * @return The CardDispenser instance.
     */
    public static CardDispenser getInstance() {
        if(instance == null) instance = new CardDispenser();
        return instance;
    }

    /**
     * Sets the deck of this object.
     * @param deck An InterfaceDeck object.
     */
    public void setDeck(@NotNull InterfaceDeck<InterfaceCard> deck) {
        this.deck = deck;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        size--;
        if(size < 0) {
            timer.stop();
            size = copy;
            updateAll();
        } else {
            for(int i = 0; i < 7; i++)
                players.get(size).add(deck.draw());
        }
    }

    public void dispense() {
        timer.start();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceProvider<?> provider) {
            players = (List<InterfacePlayer<InterfaceCard>>) provider.provide();
            size = players.size();
            copy = size;
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". GameStarter type expected.");
    }

}
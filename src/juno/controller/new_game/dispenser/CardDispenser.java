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

import juno.controller.util.Stoppable;
import juno.model.deck.InterfaceDeck;
import juno.model.subjects.InterfacePlayer;
import juno.model.util.AbstractObservable;
import juno.model.util.Donut;
import juno.model.util.Provider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class defines a card dispenser.
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class CardDispenser<T>
        extends AbstractObservable
        implements ActionListener, InterfaceCardDispenser, Stoppable {

    // The deck.
    private InterfaceDeck<T> deck;

    // The provider.
    private Provider<Donut<InterfacePlayer<T>>> provider;

    // The players size.
    private int size;

    // The timer.
    private final Timer timer;

    // The CardDispenser instance.
    private static CardDispenser<?> instance;

    // Builds the CardDispenser instance.
    private CardDispenser() {
        timer = new Timer(750, this);
    }

    /**
     * Returns the CardDispenser instance.
     * @return The CardDispenser instance.
     */
    public static CardDispenser<?> getInstance() {
        if(instance == null) instance = new CardDispenser<>();
        return instance;
    }

    /**
     * Sets the deck of this object.
     * @param deck An InterfaceDeck object.
     */
    public void setDeck(@NotNull InterfaceDeck<T> deck) {
        this.deck = deck;
    }

    /**
     * Sets the players provider of this object.
     * @param provider An InterfaceProvider object.
     */
    public void setProvider(@NotNull Provider<Donut<InterfacePlayer<T>>> provider) {
        this.provider = provider;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(size == 0) {
            timer.stop();
            updateAll();
        } else {
            size--;
            for(int i = 0; i < 7; i++)
                provider.provide().get(size).add(deck.draw());
        }
    }

    public void dispense() {
        size = provider.provide().size();
        timer.start();
    }

    @Override
    public void stop() {
        timer.stop();
    }

}
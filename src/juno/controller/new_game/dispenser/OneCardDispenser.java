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

import juno.controller.new_game.GameInitializer;
import juno.controller.util.Stoppable;
import juno.model.deck.InterfaceDeck;
import juno.model.subjects.InterfacePlayer;
import juno.model.util.AbstractObservable;
import juno.model.util.Provider;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Simone Gentili
 */
public class OneCardDispenser<T>
        extends AbstractObservable
        implements ActionListener, Observer, InterfaceCardDispenser, Provider<List<InterfacePlayer<T>>>, Stoppable {

    // The deck.
    private InterfaceDeck<T> deck;

    // The players.
    private final List<InterfacePlayer<T>> players;

    // The players size.
    private int size;

    // The timer.
    private final Timer timer;

    // The CardDispenser instance.
    private static OneCardDispenser<?> instance;

    // Builds the CardDispenser instance.
    private OneCardDispenser() {
        timer = new Timer(500, this);
        players = new ArrayList<>();
    }

    /**
     * Returns the CardDispenser instance.
     * @return The CardDispenser instance.
     */
    public static OneCardDispenser<?> getInstance() {
        if(instance == null) instance = new OneCardDispenser<>();
        return instance;
    }

    /**
     * Sets the deck of this object.
     * @param deck An InterfaceDeck object.
     */
    public void setDeck(@NotNull InterfaceDeck<T> deck) {
        this.deck = deck;
    }


    @Override
    public List<InterfacePlayer<T>> provide() {
        return players;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(size == 0) {
            timer.stop();
            updateAll();
        } else {
            size--;
            T card = deck.draw();
            players.get(size).add(card);
        }
    }

    @Override
    public void dispense() {
        size = players.size();
        timer.start();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        // The update comes from PlayersProvider
        // and the CardController class.
        if(object instanceof Provider<?> provider) {
            players.clear();
            players.addAll((Collection<? extends InterfacePlayer<T>>)
                    provider.provide());
            if(provider instanceof CardController)
                if (players.size() != 1)
                    dispense();
        } else if(object instanceof GameInitializer) {
            dispense();
        }
    }

    @Override
    public void stop() {
        timer.stop();
    }

}
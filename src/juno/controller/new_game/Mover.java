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

import juno.controller.new_game.dispenser.InterfaceCardDispenser;
import juno.model.card.InterfaceCard;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.ai.InterfaceAi;
import juno.model.util.Donut;
import juno.model.util.InterfaceProvider;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class Mover
        extends AbstractMover<InterfaceCard>
        implements ActionListener, Observer, Observable {

    // The players.
    private Donut<InterfacePlayer<InterfaceCard>> players;

    // The Observers list.
    private final List<Observer> observerList;

    // The timer.
    private final Timer timer;

    // The Mover instance.
    private static Mover instance;

    // Builds the Mover instance.
    private Mover() {
        timer = new Timer(1500, this);
        observerList = new ArrayList<>();
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
    public void actionPerformed(ActionEvent e) {
        InterfacePlayer<InterfaceCard> current = players.current();
        if(current instanceof InterfaceAi<?, ?> ai) {
            InterfaceCard card = (InterfaceCard) ai.move();
            if(card == null) {
                current.add(Objects.requireNonNull(getDeck()).draw());
                card = (InterfaceCard) ai.move();
            }
            if(card != null) {
                Objects.requireNonNull(getDiscardedPile()).discard(card);
                current.remove(card);
            } Objects.requireNonNull(getTurnMover()).next();
        } else {
            timer.stop();
            updateAll();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceCardDispenser) {
            Objects.requireNonNull(getTurnMover()).next();
            timer.start();
        } else if(object instanceof InterfaceProvider<?> provider) {
            players = (Donut<InterfacePlayer<InterfaceCard>>) provider.provide();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceCardDispenser type expected");
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
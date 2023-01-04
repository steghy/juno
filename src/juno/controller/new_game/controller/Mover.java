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

package juno.controller.new_game.controller;

import juno.controller.new_game.dispenser.InterfaceCardDispenser;
import juno.controller.util.Stoppable;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.ai.InterfaceAi;
import juno.model.subjects.shift.InterfaceTurnMover;
import juno.model.util.Donut;
import juno.model.util.Provider;
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
public class Mover<T>
        extends AbstractMover<T>
        implements ActionListener, Observer, Observable, Stoppable {

    // The players.
    private Donut<InterfacePlayer<T>> players;

    // The Observers list.
    private final List<Observer> observerList;

    // The timer.
    private final Timer timer;

    // The Mover instance.
    private static Mover<?> instance;

    // Builds the Mover instance.
    private Mover() {
        timer = new Timer(2000, this);
        observerList = new ArrayList<>();
    }

    /**
     * Returns the Mover instance.
     * @return The Mover instance.
     */
    public static Mover<?> getInstance() {
        if(instance == null) instance = new Mover<>();
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {
        InterfacePlayer<T> current = players.current();
        if(current instanceof InterfaceAi<?, ?> ai) {
            T card = (T) ai.move();
            if(card == null) {
                current.add(Objects.requireNonNull(getDeck()).draw());
                card = (T) ai.move();
            } if(card != null) {
                current.remove(card);
                timer.stop();
                Objects.requireNonNull(getDiscardedPile()).discard(card);
            } else {
                Objects.requireNonNull(getTurnMover()).next();
            }
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
        } else if(object instanceof InterfaceTurnMover) {
            timer.start();
        } else if(object instanceof Provider<?> provider) {
            players = (Donut<InterfacePlayer<T>>) provider.provide();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceCardDispenser type expected");
    }

    @Override
    public boolean addObserver(@NotNull Observer observer) {
        return observerList.add(observer);
    }

    @Override
    public boolean removeObserver(@NotNull Observer observer) {
        return observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

    @Override
    public void stop() {
        timer.stop();
    }

}
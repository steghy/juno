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

package juno.controller.new_game.penalty;

import juno.controller.util.Stoppable;
import juno.model.deck.AbstractDeckUser;
import juno.model.subjects.InterfacePlayer;
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
 * This class defines a penalty executor.
 * @author Simone Gentili
 * @param <T> The type of the card.
 */
public class PenaltyExecutor<T>
        extends AbstractDeckUser<T>
        implements ActionListener, InterfacePenaltyExecutor, Stoppable, Observable, Observer {

    // The Observers List.
    private final List<Observer> observerList;

    // Card to draw (penalty).
    private int cardToDraw;

    // The current player provider.
    private Provider<InterfacePlayer<T>> provider;

    // The timer.
    private final Timer timer;

    // The PenaltyExecutor instance.
    private static PenaltyExecutor<?> instance;

    // Builds the PenaltyExecutor instance.
    private PenaltyExecutor() {
        timer = new Timer(1000, this);
        cardToDraw = 2;
        observerList = new ArrayList<>();
    }

    /**
     * Returns the PenaltyExecutor instance.
     * @return The PenaltyExecutor instance.
     */
    public static PenaltyExecutor<?> getInstance() {
        if(instance == null) instance = new PenaltyExecutor<>();
        return instance;
    }

    /**
     * Sets the current player provider of this object.
     * @param provider An InterfaceProvider object.
     */
    public void setProvider(@NotNull Provider<InterfacePlayer<T>> provider) {
        this.provider = provider;
    }

    @Override
    public void execute() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(cardToDraw == 0) {
            timer.stop();
            cardToDraw = 2;
            updateAll();
        } else {
            provider.provide().add(Objects.requireNonNull(getDeck()).draw());
            cardToDraw--;
        }
    }

    @Override
    public void stop() {
        timer.stop();
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
    public void update(@NotNull Object object) {
        if(object instanceof PenaltyTimer penaltyTimer) {
            if(!penaltyTimer.getTimer().isRunning())
                execute();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". PenaltyTimer type expected");
    }

}
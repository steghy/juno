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
 * @param <T> The type of the card.
 */
public class PenaltyExecutor<T>
        extends AbstractDeckUser<T>
        implements ActionListener, InterfacePenaltyExecutor, Stoppable, Observable {

    // The observer list.
    private final List<Observer> observabelList;

    // Card to draw (penalty).
    private int cardToDraw;
    
    // Auxiliary variable.
    private final int aux;

    // The current player provider.
    private InterfaceProvider<InterfacePlayer<T>> provider;

    // The timer.
    private final Timer timer;

    // The PenaltyExecutor instance.
    private static PenaltyExecutor<?> instance;

    // Builds the PenaltyExecutor instance.
    private PenaltyExecutor() {
        timer = new Timer(500, this);
        timer.setInitialDelay(2000);
        cardToDraw = 2;
        aux = cardToDraw;
        observabelList = new ArrayList<>();
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
    public void setProvider(@NotNull InterfaceProvider<InterfacePlayer<T>> provider) {
        this.provider = provider;
    }

    @Override
    public void execute() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(cardToDraw == aux)
            updateAll();
        if(cardToDraw == 0) {
            timer.stop();
            cardToDraw = 2;
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
    public void addObserver(@NotNull Observer observer) {
        observabelList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observabelList.remove(observer);
    }

    @Override
    public void updateAll() {
        observabelList.forEach(observer -> observer.update(this));
    }
    
}
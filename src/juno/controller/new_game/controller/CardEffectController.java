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

import juno.controller.new_game.penalty.PenaltyExecutor;
import juno.model.card.InterfaceCard;
import juno.model.deck.InterfaceCardEffectActivator;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.ai.InterfaceAi;
import juno.model.subjects.shift.InterfaceTurnMover;
import juno.model.util.AbstractObservable;
import juno.model.util.InterfaceProvider;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class CardEffectController
        extends AbstractObservable
        implements Controller, Observer {

    // The current player provider.
    @Nullable
    private InterfaceProvider<InterfacePlayer<InterfaceCard>> provider;

    // The card effect activator.
    @Nullable
    private InterfaceCardEffectActivator<InterfaceCard> activator;

    // The turn mover.
    @Nullable
    private InterfaceTurnMover turnMover;

    // The CardEffectController instance.
    private static CardEffectController instance;

    // Builds the CardEffectController instance.
    private CardEffectController() {}

    /**
     * Returns the CardEffectController instance.
     * @return The CardEffectController instance.
     */
    public static CardEffectController getInstance() {
        if(instance == null) instance = new CardEffectController();
        return instance;
    }

    /**
     * Sets the current player provider of this object.
     * @param provider An InterfaceProvider object.
     */
    public void setProvider(@NotNull InterfaceProvider<InterfacePlayer<InterfaceCard>> provider) {
        this.provider = provider;
    }

    /**
     * Sets the card effect activator of this object.
     * @param activator An InterfaceCardEffectActivator object.
     */
    public void setActivator(@NotNull InterfaceCardEffectActivator<InterfaceCard> activator) {
        this.activator = activator;
    }

    /**
     * Sets the turn mover of this object.
     * @param turnMover An InterfaceTurnMover object.
     */
    public void setTurnMover(@NotNull InterfaceTurnMover turnMover) {
        this.turnMover = turnMover;
    }

    @Override
    public void control() {
        InterfacePlayer<InterfaceCard> current = Objects.requireNonNull(provider).provide();
        InterfaceCard card = current.provide();
        Objects.requireNonNull(activator).activate(card);
        if(!(current instanceof InterfaceAi<?,?>)) {
            if (card.action() != null && card.action().isJolly())
                updateAll();
            else Objects.requireNonNull(turnMover).next();
        } else
            Objects.requireNonNull(turnMover).next();
    }

    @Override
    public void update(@NotNull Object object) {
        // If there was a penalty, the update
        // came from the PenaltyExecutor class,
        // otherwise from the OneCardController.
        if(object instanceof Controller) {
            control();
        } else if(object instanceof PenaltyExecutor<?>) {
            control();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". Controller type expected.");
    }

}
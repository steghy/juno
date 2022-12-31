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

import juno.model.deck.InterfaceDiscardedPile;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.ai.InterfaceAi;
import juno.model.subjects.shift.TurnMover;
import juno.model.util.AbstractObservable;
import juno.model.util.InterfaceProvider;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Random;

/**
 * @author Simone Gentili
 */
public class UnoCardController<T>
        extends AbstractObservable
        implements Observer {

    // The current player provider.
    @Nullable
    private InterfaceProvider<InterfacePlayer<T>> provider;

    // The penalty executor.
    @Nullable
    private InterfacePenaltyExecutor penaltyExecutor;

    // The UnoCardController instance.
    private static UnoCardController<?> instance;

    // Builds the UnoCardController instance.
    private UnoCardController() {}

    /**
     * Returns the UnoCardController instance.
     * @return The UnoCardController instance.
     */
    public static UnoCardController<?> getInstance() {
        if(instance == null) instance = new UnoCardController<>();
        return instance;
    }

    /**
     * Sets the current player provider of this object.
     * @param provider An InterfaceProvider object.
     */
    public void setProvider(@NotNull InterfaceProvider<InterfacePlayer<T>> provider) {
        this.provider = provider;
    }

    /**
     * Sets the penalty executor of this objet.
     * @param penaltyExecutor An InterfacePenaltyExecutor object.
     */
    public void setPenaltyExecutor(@NotNull InterfacePenaltyExecutor penaltyExecutor) {
        this.penaltyExecutor = penaltyExecutor;
    }

    /**
     * Returns the current player provider of this object.
     * @return An InterfaceProvider object.
     */
    @Nullable
    public InterfaceProvider<InterfacePlayer<T>> getProvider() {
        return provider;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceDiscardedPile<?> discardedPile) {
            if(discardedPile.size() != 1) {
                if((new Random().nextInt(3) == 0)) {
                    InterfacePlayer<?> player = Objects.requireNonNull(provider).provide();
                    if (player.cards().size() == 1) {
                        Objects.requireNonNull(penaltyExecutor).execute();
                        if (player instanceof InterfaceAi<?, ?> ai) {
                            if (ai.uno())
                                penaltyExecutor.stop();
                        } else updateAll();
                    }
                } TurnMover.getInstance().next();
            }
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceDiscardedPile type expected.");
    }

}
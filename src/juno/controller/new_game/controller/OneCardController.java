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

import juno.controller.new_game.penalty.InterfacePenaltyExecutor;
import juno.controller.new_game.penalty.PenaltyTimer;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.ai.InterfaceAi;
import juno.model.util.AbstractObservable;
import juno.model.util.Provider;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * This class defines a one card controller.
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class OneCardController<T>
        extends AbstractObservable
        implements Observer, Controller {

    // The current player provider.
    @Nullable
    private Provider<InterfacePlayer<T>> provider;

    // The penalty executor.
    @Nullable
    private InterfacePenaltyExecutor penaltyExecutor;

    // The penalty timer.
    @Nullable
    private PenaltyTimer penaltyTimer;

    // The UnoCardController instance.
    private static OneCardController<?> instance;

    // Builds the UnoCardController instance.
    private OneCardController() {}

    /**
     * Returns the UnoCardController instance.
     * @return The UnoCardController instance.
     */
    public static OneCardController<?> getInstance() {
        if(instance == null) instance = new OneCardController<>();
        return instance;
    }

    /**
     * Sets the current player provider of this object.
     * @param provider An InterfaceProvider object.
     */
    public void setProvider(@NotNull Provider<InterfacePlayer<T>> provider) {
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
     * Sets the penalty timer of this object.
     * @param penaltyTimer A PenaltyTimer object.
     */
    public void setPenaltyTimer(@NotNull PenaltyTimer penaltyTimer) {
        this.penaltyTimer = penaltyTimer;
    }

    /**
     * Returns the current player provider of this object.
     * @return An InterfaceProvider object.
     */
    @Nullable
    public Provider<InterfacePlayer<T>> getProvider() {
        return provider;
    }

    @Override
    public void control() {
        InterfacePlayer<T> current = Objects.requireNonNull(getProvider()).provide();
        if(current.cards().size() == 1) {
            if(current instanceof InterfaceAi<?,?> ai) {
                if(!ai.uno()) Objects.requireNonNull(penaltyExecutor).execute();
                else updateAll();
            } else Objects.requireNonNull(penaltyTimer).startTimer();
        } else updateAll();
    }

    @Override
    public void update(@NotNull Object object) {
        // The update comes from the
        // WinConditionController class.
        if (object instanceof Controller)
            control();
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". Controller type expected.");
    }

}
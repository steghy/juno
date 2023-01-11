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

import juno.model.deck.InterfaceDiscardedPile;
import juno.model.subjects.InterfacePlayer;
import juno.model.util.AbstractObservable;
import juno.model.util.Provider;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class WinConditionController<T>
        extends AbstractObservable
        implements Observer, Controller {

    // The current player provider.
    @Nullable
    private Provider<InterfacePlayer<T>> provider;

    // The WinConditionController instance.
    private static WinConditionController<?> instance;

    // Builds the WinConditionController instance.
    private WinConditionController() {}

    /**
     * Returns the WinConditionController instance.
     * @return The WinConditionController instance.
     */
    public static WinConditionController<?> getInstance() {
        if(instance == null) instance = new WinConditionController<>();
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
    public void control() {
        InterfacePlayer<T> current = Objects.requireNonNull(provider).provide();
        if(current.cards().isEmpty()) {
            WinnerManager.getInstance().menage();
        } else updateAll();
    }

    @Override
    public void update(@NotNull Object object) {
        // The update comes from the DiscardedPile class.
        if(object instanceof InterfaceDiscardedPile<?> discardedPile) {
            if(discardedPile.size() != 1)
                control();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceDiscardedPile type expected");
    }

}
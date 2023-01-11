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

package juno.view.pages.new_game.single_player.match.panels.center.deck;

import juno.controller.log_out.Restorable;
import juno.controller.new_game.human.DiscardedCardSetter;
import juno.controller.new_game.human.DrawAction;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.shift.InterfaceTurnMover;
import juno.model.util.Provider;
import juno.model.util.Observer;
import juno.view.panels.AbstractFirstComponent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

/**
 * This class defines a Dek panel.
 * @author Simone Gentili
 * @param <T> The type of the object to provide.
 */
public class DeckPanel<T>
        extends AbstractFirstComponent
        implements Observer, Restorable {

    /** The current player provider. */
    private Provider<T> provider;

    /** The human player. */
    private T humanPlayer;

    // The DeckPanel instance.
    private static DeckPanel<?> instance;

    // Builds the DeckPanel instance.
    private DeckPanel() {}

    /**
     * Returns the DeckPanel instance.
     * @return The DeckPanel instance.
     */
    public static DeckPanel<?> getInstance() {
        if(instance == null) instance = new DeckPanel<>();
        return instance;
    }

    /** Initialize the DeckPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new BorderLayout());
        Objects.requireNonNull(getFirstComponent());
        add(getFirstComponent(), BorderLayout.CENTER);
        getFirstComponent().setEnabled(false);
    }

    /**
     * Sets the current player provider of this object.
     * @param provider An InterfaceProvider object.
     */
    public void setProvider(@NotNull Provider<T> provider) {
        this.provider = provider;
    }

    /**
     * Sets the human player of this object.
     * @param humanPlayer An Object.
     */
    public void setHumanPlayer(@NotNull T humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceTurnMover) {
            InterfacePlayer<?> current = (InterfacePlayer<?>) provider.provide();
            Objects.requireNonNull(getFirstComponent())
                    .setEnabled(current == humanPlayer);
        } else if(object instanceof DrawAction<?> ||
                object instanceof DiscardedCardSetter<?>) {
            Objects.requireNonNull(getFirstComponent()).setEnabled(false);
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceTurnMover or DrawAction type expected.");
    }

    @Override
    public void restore() {
        Objects.requireNonNull(getFirstComponent()).setEnabled(false);
    }

}
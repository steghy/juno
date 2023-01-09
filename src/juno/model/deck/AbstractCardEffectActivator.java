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

package juno.model.deck;

import juno.model.subjects.shift.InterfaceInverter;
import juno.model.subjects.shift.InterfaceTurnMover;
import juno.model.util.Provider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This abstract class defines abstract card effect activator.
 * @author Simone Gentili
 * @param <T> The type of the object to provide.
 * @param <E> the type of the cards.
 * @param <C> the type of the color.
 */
public abstract class AbstractCardEffectActivator<T, E, C>
        extends AbstractDeckUser<T>
        implements InterfaceCardEffectActivator<T> {

    /** Constructor. */
    public AbstractCardEffectActivator() {}

    // The turn jumper.
    private InterfaceTurnMover turnJumper;

    // The inverter.
    private InterfaceInverter inverter;

    // The player provider.
    private Provider<E> playersProvider;

    // The actual color.
    private InterfaceActualColorManager<C> actualColor;

    /**
     * Sets the turn mover of this object.
     * @param turnJumper An InterfaceTurnJumper object.
     */
    public void setTurnJumper(@NotNull InterfaceTurnMover turnJumper) {
        this.turnJumper = turnJumper;
    }

    /**
     * Sets the inverter of this object.
     * @param inverter An InterfaceInverter object.
     */
    public void setInverter(@NotNull InterfaceInverter inverter) {
        this.inverter = inverter;
    }

    /**
     * Sets the players provider of this object.
     * @param playersProvider An InterfaceProvider object.
     */
    public void setPlayersProvider(@NotNull Provider<E> playersProvider) {
        this.playersProvider = playersProvider;
    }

    /**
     * Sets the actual color manager of this object.
     * @param actualColor An InterfaceActualColor object.
     */
    public void setActualColor(@NotNull InterfaceActualColorManager<C> actualColor) {
        this.actualColor = actualColor;
    }

    /**
     * Returns the turn mover of this object.
     * @return An InterfaceTurnMover object.
     */
    @Nullable
    public InterfaceTurnMover getTurnJumper() {
        return turnJumper;
    }

    /**
     * Returns the inverter of this object.
     * @return An InterfaceInverter object.
     */
    @Nullable
    public InterfaceInverter getInverter() {
        return inverter;
    }

    /**
     * Returns the players provider of this object.
     * @return An InterfaceProvider object.
     */
    @Nullable
    public Provider<E> getPlayersProvider() {
        return playersProvider;
    }

    /**
     * Returns the actual color manager of this object.
     * @return An InterfaceActualColor object.
     */
    @Nullable
    public InterfaceActualColorManager<C> getActualColor() {
        return actualColor;
    }

}
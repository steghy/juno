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
import juno.model.util.InterfaceProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Simone Gentili
 */
public abstract class AbstractCardEffectActivator<T, E, C>
        extends AbstractDeckUser<T>
        implements InterfaceCardEffectActivator<T> {

    // The turn mover.
    private InterfaceTurnMover turnMover;

    // The inverter.
    private InterfaceInverter inverter;

    // The player provider.
    private InterfaceProvider<E> playersProvider;

    // The actual color.
    private InterfaceActualColor<C> actualColor;

    /**
     * Sets the turn mover of this object.
     * @param turnMover An InterfaceTurnJumper object.
     */
    public void setTurnMover(@NotNull InterfaceTurnMover turnMover) {
        this.turnMover = turnMover;
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
    public void setPlayersProvider(@NotNull InterfaceProvider<E> playersProvider) {
        this.playersProvider = playersProvider;
    }

    /**
     * Sets the actual color manager of this object.
     * @param actualColor An InterfaceActualColor object.
     */
    public void setActualColor(@NotNull InterfaceActualColor<C> actualColor) {
        this.actualColor = actualColor;
    }

    /**
     * Returns the turn mover of this object.
     * @return An InterfaceTurnMover object.
     */
    @Nullable
    public InterfaceTurnMover getTurnMover() {
        return turnMover;
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
    public InterfaceProvider<E> getPlayersProvider() {
        return playersProvider;
    }

    /**
     * Returns the actual color manager of this object.
     * @return An InterfaceActualColor object.
     */
    @Nullable
    public InterfaceActualColor<C> getActualColor() {
        return actualColor;
    }

}
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

import juno.controller.log_out.Restorable;
import juno.model.card.InterfaceCard;
import juno.model.card.colors.InterfaceColor;
import juno.model.util.AbstractObservable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class defines an acutal color manager
 * @author Simone Gentili
 */
public class ActualColorManager
        extends AbstractObservable
        implements InterfaceActualColorManager<InterfaceColor>, Observer, Restorable {

    // The actual color.
    private InterfaceColor color;

    // The ActualColorManager instance.
    private static ActualColorManager instance;

    // Builds the ActualColorManager instance.
    private ActualColorManager() {}

    /**
     * Returns the ActualColorManager instance.
     * @return The ActualColorManager instance.
     */
    public static ActualColorManager getInstance() {
        if(instance == null) instance = new ActualColorManager();
        return instance;
    }

    @Override
    public void set(@NotNull InterfaceColor color) {
        this.color = color;
        updateAll();
    }

    @Override @Nullable
    public InterfaceColor provide() {
        return color;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceDiscardedPile<?> provider) {
            Object temp = provider.provide();
            if(temp instanceof InterfaceCard card) {
                if(card.color() != null)
                    set(card.color());
            } else throw new IllegalArgumentException(
                    "Invalid object type: " + temp.getClass() +
                            ". InterfaceCard type expected.");
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceProvider type expected");

    }

    @Override
    public void restore() {
        color = null;
    }

}
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

package juno.model.subjects.human;

import juno.controller.log_out.Restorable;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class defines the human player.
 * @author Simone Gentili
 * @param <T> The type of the card.
 */
public class HumanPlayer<T>
        extends AbstractHumanPlayer<T>
        implements Restorable {

    // It's true if the last card involved
    // has been removed.
    private boolean hasRemoved;

    // The last card involved.
    private T card;

    // HumanPlayer instance.
    private static HumanPlayer<?> instance;

    // Builds the HumanPlayer instance.
    private HumanPlayer() {}

    /**
     * Returns the HumanPlayer instance.
     * @return The HumanPlayer instance.
     */
    public static HumanPlayer<?> getInstance() {
        if(instance == null) instance = new HumanPlayer<>();
        return instance;
    }

    @Override
    public String name() {
        return Objects.requireNonNull(getProvider()).provide();
    }

    @Override
    public void add(@NotNull T card) {
        cards().add(card);
        this.card = card;
        hasRemoved = false;
        updateAll();
    }

    @Override
    public void remove(@NotNull T card) {
        boolean result = cards().remove(card);
        if(!result) throw new IllegalArgumentException(
                "The card " + card + " is not in: " + cards());
        this.card = card;
        hasRemoved = true;
        updateAll();
    }

    @Override
    public T provide() {
        return card;
    }

    @Override
    public boolean hasRemoved() {
        return hasRemoved;
    }

    @Override
    public void restore() {
        card = null;
        cards().clear();
    }

}
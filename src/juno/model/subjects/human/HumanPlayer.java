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

import juno.model.subjects.InterfaceAdder;
import juno.model.subjects.InterfaceRemover;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * @author Simone Gentili
 * @param <T> The type of the card.
 */
public class HumanPlayer<T>
        extends AbstractHumanPlayer<T>
        implements InterfaceAdder<T>, InterfaceRemover<T> {

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

    @Override @Nullable
    public T move() {
        return Objects.requireNonNull(getReceiver()).receive();
    }

    @Override
    public String name() {
        return Objects.requireNonNull(getProvider()).provide();
    }

    @Override
    public void add(@NotNull T object) {
        cards().add(object);
        updateAll();
    }

    @Override
    public void remove(@NotNull T object) {
        boolean result = cards().remove(object);
        if(result) throw new IllegalArgumentException(
                "The card " + object + " is not in: " + cards());
        updateAll();
    }

}
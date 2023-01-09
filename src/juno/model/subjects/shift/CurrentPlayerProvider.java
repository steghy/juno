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

package juno.model.subjects.shift;

import juno.model.util.Donut;
import juno.model.util.Provider;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class defines the current player provider.
 * @author Simone Gentili
 * @param <T> The type of the players.
 */
public class CurrentPlayerProvider<T>
    extends AbstractPlayersMaintainer<T>
        implements Provider<T>, Observer {

    // The CurrentPlayerProvider instance.
    private static CurrentPlayerProvider<?> instance;

    // Builds the CurrentPlayerProvider instance.
    private CurrentPlayerProvider() {}

    /**
     * Returns the CurrentPlayerProvider instance.
     * @return The CurrentPlayerProvider instance
     */
    public static CurrentPlayerProvider<?> getInstance() {
        if(instance == null) instance = new CurrentPlayerProvider<>();
        return instance;
    }

    @Override
    public T provide() {
        return Objects.requireNonNull(players).current();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof Provider<?> provider) {
            players = (Donut<T>) provider.provide();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceProvider type expected");
    }

}
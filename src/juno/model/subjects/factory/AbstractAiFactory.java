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

package juno.model.subjects.factory;

import juno.model.util.Provider;
import juno.model.util.RelativeProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This abstract class defines an abstract ai factory.
 * @author Simone Gentili
 * @param <T> The type of the object to provide.
 * @param <E>  The type of the object involved.
 * @param <C> The type of the object involved.
 */
public abstract class AbstractAiFactory<T, E, C>
        implements Provider<T> {

    /** Constructor. */
    public AbstractAiFactory() {}

    // The name relative provider.
    private RelativeProvider<E, C> relativeProvider;

    /**
     * Sets the name relative provider of this object.
     * @param relativeProvider A RelativeProvider object.
     */
    public void setRelativeProvider(@NotNull RelativeProvider<E, C> relativeProvider) {
        this.relativeProvider = relativeProvider;
    }

    /**
     * Returns the name relative provider of this object.
     * @return An RelativeProvider object.
     */
    @Nullable
    public RelativeProvider<E, C> getRelativeProvider() {
        return relativeProvider;
    }

}
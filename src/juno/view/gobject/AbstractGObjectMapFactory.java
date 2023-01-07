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

package juno.view.gobject;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class defines abstract graphic object factory.
 * @author Simone Gentili
 * @param <T> The type of the objects.
 */
public abstract class AbstractGObjectMapFactory<T>
        implements InterfaceGObjectMapFactory<T>, InterfaceGObjectMapGenerator<T> {

    // The graphic object factory.
    private InterfaceGObjectFactory<T> factory;

    /**
     * Sets the graphic object factory of this object.
     * @param factory An InterfaceGObjectFactory object.
     */
    public void setFactory(@NotNull InterfaceGObjectFactory<T> factory) {
        this.factory = factory;
    }

    /**
     * Returns the graphic object factory of this object.
     * @return An InterfaceGObjectFactory object.
     */
    @Nullable
    public InterfaceGObjectFactory<T> getFactory() {
        return factory;
    }

}
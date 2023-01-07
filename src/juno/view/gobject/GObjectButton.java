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

import juno.view.util.ImageButton;
import juno.view.util.InterfaceImageResizer;
import org.jetbrains.annotations.NotNull;

/**
 * This class defines a graphic button object.
 * @author Simone Gentili
 * @param <T> The type of the object.
 */
public class GObjectButton<T>
        extends ImageButton
        implements InterfaceGObject<T> {

    // The Object.
    private final T object;

    /**
     * Builds a GObjectButton with the
     * specified object.
     * @param object An object.
     */
    public GObjectButton(@NotNull T object,
                         @NotNull InterfaceImageResizer resizer) {
        super(resizer);
        this.object = object;
    }

    @Override
    public T object() {
        return object;
    }

}
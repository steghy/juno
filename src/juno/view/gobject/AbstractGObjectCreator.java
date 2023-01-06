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

import juno.view.img_initializer.InterfaceImageComponentInitializer;
import juno.model.requester.InterfacePathProviderAssembler;
import juno.view.util.InterfaceImageResizer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractGObjectCreator<T> {

    // The path object assembler.
    private InterfacePathProviderAssembler assembler;

    // The image component initializer.
    private InterfaceImageComponentInitializer initializer;

    // The image resizer.
    private InterfaceImageResizer resizer;

    /**
     * Sets the assembler path object of this object.
     * @param assembler An InterfacePathObjectAssembler object.
     */
    public void setAssembler(@NotNull InterfacePathProviderAssembler assembler) {
        this.assembler = assembler;
    }

    /**
     * Sets the image component initializer of this object.
     * @param initializer An InterfaceImageComponentInitializer object.
     */
    public void setInitializer(@NotNull InterfaceImageComponentInitializer initializer) {
        this.initializer = initializer;
    }

    /**
     * Sets the image resizer of this object.
     * @param resizer An InterfaceImageResizer object.
     */
    public void setResizer(@NotNull InterfaceImageResizer resizer) {
        this.resizer = resizer;
    }

    /**
     * Returns the assembler path object of this object.
     * @return An InterfacePathObjectAssembler object.
     */
    @Nullable
    public InterfacePathProviderAssembler getAssembler() {
        return assembler;
    }

    /**
     * Returns the image component initializer of this object.
     * @return An InterfaceImageComponentInitializer object.
     */
    @Nullable
    public InterfaceImageComponentInitializer getInitializer() {
        return initializer;
    }

    /**
     * Returns the image resizer of this object.
     * @return An InterfaceImageResizer object.
     */
    @Nullable
    public InterfaceImageResizer getResizer() {
        return resizer;
    }

}

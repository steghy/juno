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

import juno.view.util.InterfaceImageComponentInitializer;
import juno.view.download.InterfacePathObjectAssembler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractGObjectCreator<T> {

    // The path provider.
    private InterfacePathObjectProvider<T> provider;

    // The path object assembler.
    private InterfacePathObjectAssembler assembler;

    // The image component initializer.
    private InterfaceImageComponentInitializer initializer;

    /**
     * Sets the path provider of this object.
     * @param provider An InterfacePathObjectProvider object.
     */
    public void setProvider(@NotNull InterfacePathObjectProvider<T> provider) {
        this.provider = provider;
    }

    /**
     * Sets the assembler path object of this object.
     * @param assembler An InterfacePathObjectAssembler object.
     */
    public void setAssembler(@NotNull InterfacePathObjectAssembler assembler) {
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
     * Returns the path provider of this object.
     * @return An InterfacePathObjectProvider object.
     */
    @Nullable
    public InterfacePathObjectProvider<T> getProvider() {
        return provider;
    }

    /**
     * Returns the assembler path object of this object.
     * @return An InterfacePathObjectAssembler object.
     */
    @Nullable
    public InterfacePathObjectAssembler getAssembler() {
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

}

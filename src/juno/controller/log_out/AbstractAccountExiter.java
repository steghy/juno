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

package juno.controller.log_out;

import juno.model.data.io.output.AbstractExporterManagerUser;
import juno.model.util.InterfaceGenerator;
import juno.model.util.InterfaceProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simone Gentili
 */
public abstract class AbstractAccountExiter<T>
        extends AbstractExporterManagerUser<T>
        implements InterfaceAccountExiter {

    // The restorable.
    private final List<Restorable> restorableList = new ArrayList<>();

    // The object provider.
    private InterfaceProvider<T> provider;

    // The profile files refresher.
    private InterfaceGenerator generator;

    /**
     * Sets the provider of this object.
     * @param provider An InterfaceProvider object.
     */
    public void setProvider(@NotNull InterfaceProvider<T> provider) {
        this.provider = provider;
    }

    /**
     * Sets the generator of this object.
     * @param generator An InterfaceGenerator object.
     */
    public void setGenerator(@NotNull InterfaceGenerator generator) {
        this.generator = generator;
    }

    /**
     * Returns the restorable object of this object.
     * @return A Restorable object.
     */
    public List<Restorable> getRestorableList() {
        return restorableList;
    }

    /**
     * Returns the provider of this object.
     * @return An InterfaceProvider object.
     */
    @Nullable
    public InterfaceProvider<T> getProvider() {
        return provider;
    }

    /**
     * Returns the generator of this object.
     * @return An InterfaceGenerator object.
     */
    @Nullable
    public InterfaceGenerator getGenerator() {
        return generator;
    }

}
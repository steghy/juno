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

package juno.model.data.io.output;

import juno.model.util.Provider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This abstract class defines an exit manager object.
 * @author Simone Gentili
 * @param <T> The type of the object to provide.
 */
public abstract class AbstractExitManager<T>
        implements InterfaceExitManager {

    /** Constructor. */
    public AbstractExitManager() {}

    // The exporter manager.
    private InterfaceExporterManager<T> exporter;

    // The object to export provider.
    private Provider<T> provider;

    /**
     * Sets the exporter manager of this object.
     * @param exporter An InterfaceExporterManager object.
     */
    public void setExporter(@NotNull InterfaceExporterManager<T> exporter) {
        this.exporter = exporter;
    }

    /**
     * Sets the provider of this object.
     * @param provider An InterfaceProvider object.
     */
    public void setProvider(@NotNull Provider<T> provider) {
        this.provider = provider;
    }

    /**
     * Returns the exporter manager of this object.
     * @return An InterfaceExporterManager object.
     */
    @Nullable
    public InterfaceExporterManager<T> getExporter() {
        return exporter;
    }

    /**
     * Returns the provider of this object.
     * @return An InterfaceProvider object.
     */
    @Nullable
    public Provider<T> getProvider() {
        return provider;
    }

}
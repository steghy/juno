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

package juno.controller.pre_access.log_in.entry_builders;

import juno.controller.pre_access.log_in.path_builders.InterfacePathBuilder;
import juno.model.data.io.input.InterfaceDataImporter;
import juno.model.data.io.input.configurable.Configurable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Simone Gentili
 */
public abstract class AbstractEntryBuilder
        implements InterfaceEntryBuilder {

    // The path builder.
    private InterfacePathBuilder builder;

    // The data importer.
    private InterfaceDataImporter importer;

    // The configurable.
    private Configurable configurable;

    /**
     * Sets the builder of this object.
     * @param builder An InterfaceBuilder object.
     */
    public void setBuilder(@NotNull InterfacePathBuilder builder) {
        this.builder = builder;
    }

    /**
     * Sets the configurable object of this object.
     * @param configurable A Configurable object.
     */
    public void setConfigurable(@NotNull Configurable configurable) {
        this.configurable = configurable;
    }

    /**
     * Sets the data importer of this object.
     * @param importer An InterfaceDataImporter object.
     */
    public void setImporter(@NotNull InterfaceDataImporter importer) {
        this.importer = importer;
    }

    /**
     * Returns the builder of this object.
     * @return An InterfacePathBuilder object.
     */
    @Nullable
    public InterfacePathBuilder getBuilder() {
        return builder;
    }

    /**
     * Returns the configurable object of this object.
     * @return A Configurable object.
     */
    @Nullable
    public Configurable getConfigurable() {
        return configurable;
    }

    /**
     * Returns the data importer of this object.
     * @return An InterfaceDataImporter object.
     */
    @Nullable
    public InterfaceDataImporter getImporter() {
        return importer;
    }
}
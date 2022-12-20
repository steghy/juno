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

package juno.view.gobject.profiles;

import juno.model.data.io.input.InterfaceDataImporter;
import juno.view.gobject.AbstractGObjectFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Simone Gentili
 */
public abstract class AbstractGProfileFactory<T>
        extends AbstractGObjectFactory<T> {

    // Profile name key.
    private String key;

    // The data importer.
    private InterfaceDataImporter importer;

    public void setKey(@NotNull String key) {
        this.key = key;
    }

    /**
     * Sets the data importer of this object.
     * @param importer An InterfaceDataImporter object.
     */
    public void setImporter(@NotNull InterfaceDataImporter importer) {
        this.importer = importer;
    }

    /**
     * Returns the profile name key of this object.
     * @return A String object.
     */
    @Nullable
    public String getKey() {
        return key;
    }

    /**
     * Returns the importer of this object.
     * @return An InterfaceDataImporter object.
     */
    @Nullable
    public InterfaceDataImporter getImporter() {
        return importer;
    }

}
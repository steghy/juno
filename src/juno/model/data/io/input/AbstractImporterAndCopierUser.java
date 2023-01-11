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

package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This abstract class defines compatibility
 * checkers between files and objects that
 * use importer and copier to operate.
 * @author Simone Gentili
 */
public abstract class AbstractImporterAndCopierUser {

    /** Constructor. */
    public AbstractImporterAndCopierUser() {}

    // The importer.
    private InterfaceDataImporter importer;

    // The copier.
    private InterfacePropertyCopier copier;

    /**
     * Sets the importer of this object.
     * @param importer An InterfaceDataImporter object.
     */
    public void setImporter(@NotNull InterfaceDataImporter importer) {
        this.importer = importer;
    }

    /**
     * Sets the copier of this object.
     * @param copier An InterfacePropertyCopier object.
     */
    public void setCopier(@NotNull InterfacePropertyCopier copier) {
        this.copier = copier;
    }

    /**
     * Returns the importer of this object.
     * @return An InterfaceDataImporter.
     */
    @Nullable
    public InterfaceDataImporter getImporter() {
        return importer;
    }

    /**
     * Returns the copier of this object.
     * @return An InterfacePropertyCopier object.
     */
    @Nullable
    public InterfacePropertyCopier getCopier() {
        return copier;
    }

}
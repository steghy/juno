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


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Simone Gentili
 */
public abstract class AbstractExporterManager
        extends AbstractDataExporterUser
        implements InterfaceExporterManager {

    // The Exportable Map.
    private final Map<Exportable, String> exportableMap = new HashMap<>();

    // The map of exportable setter.
    private InterfaceExportableSetter exportableSetter;

    /**
     * Returns the map of Exportable objects.
     * @return A Map object.
     */
    public Map<Exportable, String> exportableMap() {
        return exportableMap;
    }

    /**
     * Sets the map of exportable setter of this object.
     * @param exportableSetter An InterfaceMapOfExportableSetter object.
     */
    public void setExportableSetter(@NotNull InterfaceExportableSetter exportableSetter) {
        this.exportableSetter = exportableSetter;
    }

    /**
     * Returns the map of exportable setter of this object.
     * @return An InterfaceMapOfExportableSetter object.
     */
    @Nullable
    public InterfaceExportableSetter getExportableSetter() {
        return exportableSetter;
    }

}
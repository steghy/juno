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

import java.util.Map;

/**
 * @author Simone Gentili
 */
public class CCompatibilityChecker
        extends AbstractCompatibilityChecker
        implements InterfaceStringCCompatibilityChecker, InterfaceMapCCompatibilityChecker {

    /* The CCompatibilityChecker instance */
    private static CCompatibilityChecker instance;

    /* Builds the CCompatibilityChecker instance */
    private CCompatibilityChecker() {}

    /**
     * Returns the CCompatibilityChecker instance.
     * @return The CCompatibilityChecker instance.
     */
    public static CCompatibilityChecker getInstance() {
        if(instance == null) instance = new CCompatibilityChecker();
        return instance;
    }

    @Override
    public boolean checkCompatibilityOf(@NotNull Configurable configurable,
                                        @NotNull String path) {
        Map<String, Object> properties = getPropertyCopier().copy(configurable);
        boolean isValid = false;
        try {
            Map<String, Object> map = getDataImporter().importData(path);
            if(!map.isEmpty()) {
                configurable.configure(map);
                isValid = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        if(!properties.isEmpty())
            configurable.configure(properties);
        return isValid;
    }

    @Override
    public boolean checkCompatibilityOf(@NotNull Configurable configurable,
                                        @NotNull Map<String, Object> map) {
        Map<String, Object> properties = getPropertyCopier().copy(configurable);
        boolean isValid = false;
        try {
            if(!map.isEmpty()) {
                configurable.configure(map);
                isValid = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        if(!properties.isEmpty())
            configurable.configure(properties);
        return isValid;
    }
}
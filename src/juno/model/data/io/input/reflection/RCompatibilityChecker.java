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

package juno.model.data.io.input.reflection;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

/**
 * This class represents a compatibility checker
 * between a configuration file and an object.
 * A file is considered compatible only if,
 * during the configuration process, no exceptions
 * are thrown. Before configuring the object with
 * the specified file, a copy of the object is made.
 * The copy of the object is contained within a
 * Map object. Before configuring the
 * object with the specified file, a copy of the
 * object is made. The copy of the object is contained
 * within a Map object and is obtained
 * using the PropertyClass. This copy of the object
 * is used to configure it at the end of the
 * operation in order to restore its state.
 * The operations performed are made possible
 * through the use of reflection.
 * @author Simone Gentili
 */
public class RCompatibilityChecker
        extends AbstractConfiguratorAndDataImporterUser
        implements InterfaceRCompatibilityChecker {

    /** The CompatibilityChecker instance. */
    private static RCompatibilityChecker instance;

    /** Builds the CompatibilityChecker instance. */
    private RCompatibilityChecker() {
        super();
    }

    /**
     * Returns the CompatibilityChecker instance.
     * @return The CompatibilityChecker instance.
     */
    public static RCompatibilityChecker getInstance() {
        if(instance == null) instance = new RCompatibilityChecker();
        return instance;
    }

    @Override
    public boolean areCompatible(@NotNull Object object,
                                 @NotNull String path) {
        boolean isCompatible = false;
        // Checking the compatibility of the data with the object.
        // An Exception causes the incompatibility.
        try {
            Map<String, Object> map = Objects.requireNonNull(getImporter()).importData(path);
            // Empty map equals = incompatible file.
            if(!map.isEmpty()) {
                Objects.requireNonNull(getConfigurator()).configure(object, map);
                isCompatible = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        } return isCompatible;
    }

}
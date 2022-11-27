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

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * This class defines two methods (implemented by the
 * 'InterfaceRCompatibilityChecker' interface) for
 * determining the compatibility of a given configuration
 * file (described by a path) and an object
 * @author Simone Gentili
 */
public class RCompatibilityChecker
        extends AbstractRCompatibilityChecker
        implements InterfaceRCompatibilityChecker{

    /* The RCompatibilityChecker instance */
    private static RCompatibilityChecker instance;

    /* Builds the RCompatibilityChecker instance */
    private RCompatibilityChecker() {}

    /**
     * Returns the RCompatibilityChecker instance.
     * @return The RCompatibilityChecker instance.
     */
    public static RCompatibilityChecker getInstance() {
        if(instance == null) instance = new RCompatibilityChecker();
        return instance;
    }

    @Override
    public boolean checkCompatibilityOf(@NotNull Object object,
                                        @NotNull String path) {
        // Taking a copy of the object's data.
        Map<String, Object> properties = getPropertyCopier().copy(object);

        boolean isCompatible = false;

        // Checking the compatibility of the data with the object.
        // An Exception causes te incompatibility.
        try {
            Map<String, Object> map = getDataImporter().importData(path);
            System.out.println(map);
            // Empty map = Incompatible.
            if(!map.isEmpty()) {
                getRConfigurator().configure(map, object);
                isCompatible = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        // Attempt to restore the initial state of the object.
        try {
            getRConfigurator().configure(properties, object);
        } catch (IllegalAccessException |
                 NoSuchFieldException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        } return isCompatible;
    }

    @Override
    public boolean checkCompatibilityOf(@NotNull Class<?> clazz,
                                        @NotNull String path) {
        // Taking a copy of the object's data.
        Map<String, Object> properties = getPropertyCopier().copy(clazz);

        boolean isCompatible = false;

        // Checking the compatibility of the data with the object.
        // An Exception causes te incompatibility.
        try {
            Map<String, Object> map = getDataImporter().importData(path);
            // Empty map = Incompatible.
            if(!map.isEmpty()) {
                getRConfigurator().configure(map, clazz);
                isCompatible = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        // Attempt to restore the initial state of the object.
        try {
             getRConfigurator().configure(properties, clazz);
        } catch (IllegalAccessException |
                  NoSuchFieldException |
                  InvocationTargetException e) {
            throw new RuntimeException(e);
        } return isCompatible;
    }
}
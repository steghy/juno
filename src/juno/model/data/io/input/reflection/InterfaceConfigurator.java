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

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * This interface defines a method for configuring
 * an object using a Map<String, Object>.
 * @author Simone Gentili
 */
public interface InterfaceConfigurator {

    /**
     * Configure the specified object with
     * the specified map.
     * @param map A Map<String, Object> object.
     * @param object An Object.
     * @throws IllegalAccessException Occurs when
     *         operations on a field that could result
     *         in this exception being thrown are
     *         performed before the setAccessible(true)
     *         method is invoked on that field.
     * @throws NoSuchFieldException If there is a key
     *         within the map that is not equal to any
     *         field name of the specified object.
     * @throws InvocationTargetException If the value
     *         associated with a key withing the map
     *         which is equal to the name of a field
     *         of the object whose type is an enum
     *         class is not equal to any object name
     *         of the field's enum class.
     */
    void configure(Object object, Map<String, Object> map) throws
            IllegalAccessException,
            NoSuchFieldException,
            InvocationTargetException;

}
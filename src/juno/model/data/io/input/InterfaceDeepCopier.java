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

import java.util.Map;

/**
 * This interface defines (recursive) copiers of
 * objects. The data copied from a specific object
 * is placed inside a Map<String, Object> object
 * in which the keys are the names of the fields
 * of the object and the values the respective
 * values of those fields.
 * @author Simone Gentili
 */
@FunctionalInterface
public interface InterfaceDeepCopier {

    /**
     * Returns a map containing key-value pairs where
     * the keys are the object's field names and the
     * values are the respective values of those fields.
     * @param object An Object.
     * @return A Map object.
     * @throws IllegalAccessException Occurs when
     *         operations on a field that could result
     *         in this exception being thrown are
     *         performed before the setAccessible(true)
     *         method is invoked on that field.
     */
    Map<String, Object> deepCopy(Object object) throws IllegalAccessException;

}
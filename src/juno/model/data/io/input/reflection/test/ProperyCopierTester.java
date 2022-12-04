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

package juno.model.data.io.input.reflection.test;

import juno.model.data.io.input.PropertyCopier;
import juno.model.data.io.input.reflection.Configurator;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ProperyCopierTester {

    public static void main(String[] args) {
        MyObject target = new MyObject();
        PropertyCopier propertyCopier = PropertyCopier.getInstance();
        Configurator configurator = Configurator.getInstance();

        // The object property copy
        Map<String, Object> objectCopy = propertyCopier.copy(target);

        // Input map.
        Map<String, Object> map = new HashMap<>();
        map.put("value", 999);
        map.put("value2", 1);

        // Configuration of the object.
        try {
            configurator.configure(target, map);
        } catch (NoSuchFieldException |
                 IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        PrintStatus.printStatus(target);

        System.out.println("----------------------------");

        // Attempt to restore the initial state of the object.
        try {
            configurator.configure(target, objectCopy);
        } catch (NoSuchFieldException |
                 IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }

        PrintStatus.printStatus(target);
    }
}

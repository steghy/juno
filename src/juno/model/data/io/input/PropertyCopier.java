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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * This class defines a property copier of
 * an object. The copy method makes a copy
 * of the specified object using reflection.
 * Furthermore, the copy method is not recursive
 * (For copying the data of an object recursively
 * see the DeepPropertyCopier class documentation).
 * @author Simone Gentili
 */
public class PropertyCopier
        implements InterfacePropertyCopier {

    // The PropertyCopier instance.
    private static PropertyCopier instance;

    // Builds the PropertyCopier instance.
    private PropertyCopier() {}

    /**
     * Returns the PropertyCopier instance.
     * @return The PropertyCopier instance.
     */
    public static PropertyCopier getInstance() {
        if(instance == null) instance = new PropertyCopier();
        return instance;
    }

    @Override
    public Map<String, Object> copy(@NotNull Object object) {
        Map<String, Object> map = new HashMap<>();

        // Prevent the error of considering the fields of class 'Class'
        // in case the object passed in input was of type Class.
        Field[] fields = object instanceof Class<?> klass ? klass.getDeclaredFields() :
                object.getClass().getDeclaredFields();

        for(Field field : fields) {
            try {
                // It may throw an InaccessibleObjectException
                // for some Java standard library classes.
                field.setAccessible(true);

                // Singleton class case, unnecessary.
                if(field.getType() == object.getClass()) continue;

                // Final fields are ignored.
                if(!Modifier.isFinal(field.getModifiers()))
                    map.put(field.getName(), field.get(object));

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } return map;
    }

}
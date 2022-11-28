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
import java.lang.reflect.InaccessibleObjectException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Simone Gentili
 */
public class PropertyCopier
        implements InterfacePropertyCopier {

    /* The PropertyCopier instance */
    private static PropertyCopier instance;

    /* Builds the PropertyCopier instance */
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
        for(Field field : object.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if(!Modifier.isFinal(Modifier.fieldModifiers()))
                    map.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InaccessibleObjectException e) {
                throw new IllegalArgumentException("object" + object + " contains a field which cannot be" +  " accessible. Field: " + field);
        }
        } return map;
    }

    @Override
    public Map<String, Object> copy(@NotNull Class<?> clazz) {
        Map<String, Object> map = new HashMap<>();
        for(Field field : clazz.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if(Modifier.isStatic(field.getModifiers()))
                    if(!Modifier.isFinal(field.getModifiers()))
                        map.put(field.getName(), field.get(null));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InaccessibleObjectException e) {
                throw new IllegalArgumentException(clazz +
                        " contains a field which cannot be" +
                        " accessible. Field: " + field);
            }
        } return map;
    }
}
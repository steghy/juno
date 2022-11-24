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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class PropertyDeepCopier
        implements InterfaceDeepCopier {

    private static PropertyDeepCopier instance;

    private PropertyDeepCopier() {}

    public static PropertyDeepCopier getInstance() {
        if (instance == null) instance = new PropertyDeepCopier();
        return instance;
    }

    @Override
    public Map<String, Object> deepCopy(@NotNull Object object) {
        Map<String, Object> map = new HashMap<>();
        for(Field field : object.getClass().getDeclaredFields()) {
            try {
                if(!Modifier.isFinal(field.getModifiers())) {
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    if(type == object.getClass()) continue;
                    switch (type.getSimpleName()) {
                        case    ("String"), ("BigDecimal"),
                                ("Integer") , ("Double"),
                                ("Float"), ("Character"),
                                ("Boolean"), ("Short"),
                                ("Byte"), ("Long"),
                                ("int"), ("double"),
                                ("float"), ("short"),
                                ("long"), ("char"),
                                ("byte"), ("boolean")
                                -> map.put(field.getName(), field.get(object));
                        default -> map.put(field.getName(), deepCopy(field.get(object)));
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } return map;
    }

    @Override
    public Map<String, Object> deepCopy(@NotNull Class<?> clazz) {
        Map<String, Object> map = new HashMap<>();
        for(Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if(Modifier.isStatic(field.getModifiers())) {
                    if(!Modifier.isFinal(field.getModifiers())) {
                        field.setAccessible(true);
                        Class<?> type = field.getType();
                        if(type == clazz) continue;
                        switch (type.getSimpleName()) {
                            case    ("String"), ("BigDecimal"),
                                    ("Integer"), ("Double"),
                                    ("Float"), ("Character"),
                                    ("Boolean"), ("Short"),
                                    ("Byte"), ("Long"),
                                    ("int"), ("double"),
                                    ("float"), ("short"),
                                    ("long"), ("char"),
                                    ("byte"), ("boolean")
                                    -> map.put(field.getName(), field.get(null));
                            default -> map.put(field.getName(), deepCopy(field.get(null)));
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } return map;
    }
}
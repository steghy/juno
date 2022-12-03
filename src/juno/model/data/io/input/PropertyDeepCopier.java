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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Simone Gentili
 */
public class PropertyDeepCopier
        implements InterfaceDeepCopier {

    /* The PropertyDeepCopier instance */
    private static PropertyDeepCopier instance;

    /* Builds the PropertyDeepCopier instance. */
    private PropertyDeepCopier() {}

    /**
     * Returns the PropertyDeepCopier instance.
     * @return The PropertyDeepCopier instance.
     */
    public static PropertyDeepCopier getInstance() {
        if (instance == null) instance = new PropertyDeepCopier();
        return instance;
    }

    @Override
    public Map<String, Object> deepCopy(@NotNull Object object) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        for(Field field : object.getClass().getDeclaredFields()) {
                if(!Modifier.isFinal(field.getModifiers())) {
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    if(fieldType == object.getClass()) continue;
                    switch (fieldType.getSimpleName()) {
                        /*
                        Inspection for these values is unnecessary and
                        would result in an exception (InaccessibleObjectException)
                        anyway.
                         */
                        case    ("String"),
                                ("Integer"),   ("int"),
                                ("Double"),    ("double"),
                                ("Float"),     ("float"),
                                ("Short"),     ("short"),
                                ("Long"),      ("long"),
                                ("Character"), ("char"),
                                ("Byte"),      ("byte"),
                                ("Boolean"),   ("boolean")
                                -> map.put(field.getName(), field.get(object));
                        // BigDecimal to double.
                        case    ("BigDecimal")
                                -> map.put(field.getName(), ((BigDecimal)field.get(object)).doubleValue());
                        // BigInteger to int.
                        case    ("BigInteger")
                                -> map.put(field.getName(), ((BigInteger)field.get(object)).intValue());
                        // Recursive call to fetch the values from the object.
                        // Possible InaccessibleObjectException
                        default -> map.put(field.getName(), deepCopy(field.get(object)));
                    }
                }
        } return map;
    }

}
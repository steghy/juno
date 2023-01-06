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

import juno.model.util.MathUtility;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/**
 * This class defines a Configurator for objects.
 * The implemented method of the 'InterfaceConfigurator'
 * interface allows to configure an object using
 * a Map<String, Object>. Using reflection the
 * 'configure()' method inserts directly the values
 * from the specified map into the fields of the object.
 * Note: the final fields of the object to be configured
 * are ignored.
 * @author Simone Gentili
 */
public class Configurator
        implements InterfaceConfigurator {

    // The Configurator instance.
    private static Configurator instance;

    // Builds the Configurator instance.
    private Configurator() {}

    /**
     * Returns the Configurator instance.
     * @return The Configurator instance.
     */
    public static Configurator getInstance() {
        if(instance == null) instance = new Configurator();
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void configure(@NotNull Object object,
                          @NotNull Map<String, Object> map)
            throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {

        // Prevent the error of considering the fields of class 'Class'
        // in case the object passed in input was of type Class.
        Class<?> clazz = object instanceof Class<?> ? (Class<?>) object : object.getClass();
        for(Map.Entry<String, Object> entry : map.entrySet()) {

            String key = entry.getKey();
            Field field = clazz.getDeclaredField(key);

            // Not allowed.
            if(Modifier.isFinal(field.getModifiers())) continue;

            Object value = entry.getValue();

            // It may throw an InaccessibleObjectException
            // for some Java standard library classes.
            field.setAccessible(true);

            Class<?> fieldType = field.getType();
            Class<?> valueType = value.getClass();

            // Recursively configuration of the field with
            // the obtained map.
            if(value instanceof Map<?, ?> anotherMap) {
                if(!anotherMap.isEmpty())
                    configure(field.get(object), (Map<String, Object>) anotherMap);
            }

            // Same types case.
            else if(fieldType == valueType) {
                field.set(object, value);
            }

            // Enum type case.
            else if(fieldType.isEnum()) {
                try {
                    if(value instanceof String enumObjectName) {
                        Method valueOf = fieldType.getMethod("valueOf", String.class);
                        Object enumObject = valueOf.invoke(null, enumObjectName);
                       field.set(object, enumObject);
                    } else {
                        throw new IllegalArgumentException("Invalid value type: " + valueType +
                                " associated with the key " + key + ". Expected: " + fieldType);
                    }
                    // it can't happen.
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }

            /*
            Numbers type case:
            MathUtility.isNumberType(Class<?>) returns true if, and
            only if, the specified Class is one of the following Classes:
            Integer, int, Double, double, Short, short, Long, long,
            Float, float, BigDecimal, BigInteger. It is checked if the
            numerical value coming from the map is out of range for the
            numeric type of the field. If it's not out of range, then
            the value coming from the map is converted to the type of the
            field (if necessary) and set to it.
             */
            else if(MathUtility.isNumberType(fieldType) &&
                    MathUtility.isNumberType(valueType)) {

                // Conversion to String object.
                String stringValue;
                if(valueType == BigDecimal.class) {
                    stringValue = String.valueOf(((BigDecimal) value).doubleValue());
                } else if(valueType == BigInteger.class) {
                    stringValue = String.valueOf(((BigInteger) value).doubleValue());
                } else {
                    stringValue = String.valueOf(value);
                }

                // Checking range.
                if(MathUtility.isOutOfRange(stringValue, fieldType)) {
                    throw new IllegalArgumentException("value " + stringValue +
                            " associated with the key " + key + " is out of " +
                            "range for type (" + fieldType + ")");
                } else {
                    BigDecimal temp = new BigDecimal(stringValue);
                    switch (fieldType.getSimpleName()) {
                        case ("int"), ("Integer"),
                                ("BigInteger")      -> field.set(object, temp.intValue());
                        case ("double"), ("Double") -> field.set(object, temp.doubleValue());
                        case ("float"), ("Float")   -> field.set(object, temp.floatValue());
                        case ("short"), ("Short")   -> field.set(object, temp.shortValue());
                        case ("long"), ("Long")     -> field.set(object, temp.longValue());
                        case ("BigDecimal")         -> field.set(object, temp);
                        default -> throw new RuntimeException("Unexpected type: " + fieldType);
                    }
                }
            } else {
                throw new IllegalArgumentException("Invalid value type (" + valueType +
                        ") for key (" + key + "). Expected type (" + fieldType + ")");
            }
        }
    }
}
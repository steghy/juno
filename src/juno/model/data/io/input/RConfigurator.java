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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/**
 * This class exposes two methods for configuring Object
 * and Class types using Map objects. The 'reflected' package
 * is used to insert compatible into the object fields.
 * For numeric fields (like Integer, int, BigInteger, Double, ..)
 * in case the value from the map is also a number, but of
 * a different type, it is evaluated whether it is possible
 * to cast, and if it is, the value is inserted in the field.
 * @author Simone Gentili
 */
public class RConfigurator
        implements InterfaceRConfigurator{

    /* The RConfigurator instance */
    private static RConfigurator instance;

    /* Builds the RConfigurator instance */
    private RConfigurator() {}

    /**
     * Returns the RConfigurator instance.
     * @return The RConfigurator instance.
     */
    public static RConfigurator getInstance() {
        if(instance == null) instance = new RConfigurator();
        return instance;
    }

    @Override
    public void configure(@NotNull Map<?, ?> map,
                          @NotNull Object object) throws NoSuchFieldException,
                                                         IllegalAccessException,
                                                         InvocationTargetException {
        Class<?> objectType = object.getClass();
        for(Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Field field = objectType.getDeclaredField((String) key);

            // Not allowed.
            int modifiers = field.getModifiers();
            if(Modifier.isStatic(modifiers) &&
                    Modifier.isFinal(modifiers)) {
                continue; // throw RuntimeException() ?
            }

            Object value = entry.getValue();
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            Class<?> valueType = value.getClass();

            // Recursively configuration of the field with
            // the obtained map.
            if(value instanceof Map<?, ?> anotherMap) {
                if(!anotherMap.isEmpty())
                    configure(anotherMap, field.get(object));
            }

            // Same types case.
            else if(fieldType == valueType) {
                field.set(object, value);
            }

            // Enum type case
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
                String stringValue;
                if(valueType == BigDecimal.class) {
                    stringValue = String.valueOf(((BigDecimal) value).doubleValue());
                } else if(valueType == BigInteger.class) {
                    stringValue = String.valueOf(((BigInteger) value).doubleValue());
                } else {
                    stringValue = String.valueOf(value);
                } if(MathUtility.isOutOfRange(stringValue, fieldType)) {
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

    @Override
    public void configure(@NotNull Map<?, ?> map,
                          @NotNull Class<?> clazz)  throws NoSuchFieldException,
                                                           IllegalAccessException,
                                                           InvocationTargetException {
        for(Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Field field = clazz.getDeclaredField((String) key);

            int modifiers = field.getModifiers();
            // The field must be static and not final.
            if(!Modifier.isStatic(modifiers)) {
                continue; // throw RuntimeException() ?
            } if(Modifier.isFinal(modifiers)) {
                continue; // throw RuntimeException() ?
            }

            Object value = entry.getValue();
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            Class<?> valueType = value.getClass();

            // Recursively configuration of the field with
            // the obtained map.
            if (value instanceof Map<?, ?> anotherMap) {
                if(!anotherMap.isEmpty()) {
                    configure(anotherMap, field.get(clazz));
                }
            }

            // Same types case.
            else if (fieldType == valueType) {
                field.set(clazz, value);
            }

            // Enum class case.
            else if (fieldType.isEnum()) {
                try {
                    if (value instanceof String enumObjectName) {
                        Method valueOf = fieldType.getMethod("valueOf", String.class);
                        Object enumObject = valueOf.invoke(null, enumObjectName);
                        field.set(clazz, enumObject);
                    } else {
                        throw new IllegalArgumentException("Invalid value type: " + valueType +
                                " associated with the key " + key + ". Expected: " + fieldType);
                    }
                    // It can't happen
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

                // Conversion to String object
                String stringValue;
                if(valueType == BigDecimal.class) {
                    stringValue = String.valueOf(((BigDecimal) value).doubleValue());
                } else if(valueType == BigInteger.class) {
                    stringValue = String.valueOf(((BigInteger) value).doubleValue());
                } else {
                    stringValue = String.valueOf(value);
                }

                // Checking range
                if(MathUtility.isOutOfRange(stringValue, fieldType)) {
                    throw new IllegalArgumentException("value " + stringValue +
                            " associated with the key " + key + " is out of " +
                            "range for type (" + fieldType + ")");
                } else {
                    BigDecimal temp = new BigDecimal(stringValue);
                    switch (fieldType.getSimpleName()) {
                        case ("int"), ("Integer"),
                                     ("BigInteger") -> field.set(clazz, temp.intValue());
                        case ("double"), ("Double") -> field.set(clazz, temp.doubleValue());
                        case ("float"), ("Float")   -> field.set(clazz, temp.floatValue());
                        case ("short"), ("Short")   -> field.set(clazz, temp.shortValue());
                        case ("long"), ("Long")     -> field.set(clazz, temp.longValue());
                        case ("BigDecimal")         -> field.set(clazz, temp);
                        default -> throw new RuntimeException("Unexpected type: " + fieldType);
                    }
                }

                // Invalid type case.
            } else {
                throw new IllegalArgumentException("Invalid value type (" + valueType +
                        ") for key (" + key + "). Expected type (" + fieldType + ")");
            }
        }
    }
}

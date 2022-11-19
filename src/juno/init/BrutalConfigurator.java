package juno.init;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;

public class BrutalConfigurator {

    public static void configure(Map<?, ?> map, Object object) {
        Class<?> objectType = object.getClass();
        map.forEach((key, value) -> {
            try {

                // Field target
                Field field = objectType.getDeclaredField((String) key);

                // Access guaranteed
                field.setAccessible(true);

                // Object types
                Class<?> fieldType = field.getType();
                Class<?> valueType = value.getClass();

                // Complex object case - NOT TESTED !!!
                if(value instanceof Map<?, ?> anotherMap) {
                    configure(anotherMap, field.get(object));
                }

                // Class case
                else if (fieldType == valueType) {
                    field.set(object, value);
                }

                /*
                 * Primitive case
                 * All Java primitive types:
                 * - int
                 * - double
                 * - short
                 * - long
                 * - float
                 * - char
                 * - boolean
                 * - byte
                 */
                else if (fieldType.isPrimitive()) {
                    String fieldTypeName = fieldType.getName();
                    switch (fieldTypeName) {
                        case "int":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(object, bigDecimal.intValue());
                            } else if (value instanceof Integer integerValue) {
                                field.set(object, integerValue);
                            } else {
                                throw new IllegalArgumentException("Uncompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                            break;
                        case "double":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(object, bigDecimal.doubleValue());
                            } else if (value instanceof Double doubleValue) {
                                field.set(object, doubleValue);
                            } else {
                                throw new IllegalArgumentException("Uncompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        case "short":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(object, bigDecimal.shortValue());
                            } else if (value instanceof Short shortValue) {
                                field.set(object, shortValue);
                            } else {
                                throw new IllegalArgumentException("Uncompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        case "long":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(object, bigDecimal.longValue());
                            } else if (value instanceof Long longValue) {
                                field.set(object, longValue);
                            } else {
                                throw new IllegalArgumentException("Uncompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        case "float":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(object, bigDecimal.floatValue());
                            } else if (value instanceof Float floatValue) {
                                field.set(object, floatValue);
                            } else {
                                throw new IllegalArgumentException("Uncompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                            break;
                        case "char":
                            if (value instanceof Character characterValue) {
                                field.set(object, characterValue);
                            } else {
                                throw new IllegalArgumentException("Uncompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        case "boolean":
                            if (value instanceof Boolean booleanValue) {
                                field.set(object, booleanValue);
                            } else {
                                throw new IllegalArgumentException("Uncompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        case "byte":
                            if (value instanceof Byte byteValue) {
                                field.set(object, byteValue);
                            } else {
                                throw new IllegalArgumentException("Uncompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                    }
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
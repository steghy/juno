package juno.model.util;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Map;

public class ReflectedConfigurator {

    public static void configure(@NotNull Map<?, ?> map, @NotNull Object object) {
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

                // Complex object case
                if(value instanceof Map<?, ?> anotherMap) {
                    configure(anotherMap, field.get(object));
                }

                // Same class type case
                else if (fieldType == valueType) {
                    field.set(object, value);
                }

                // Enum class case
                else if(fieldType.isEnum()) {
                    try {
                        if(value instanceof String enumObjectName) {
                            Method valueOf = fieldType.getMethod("valueOf", String.class);
                            Object enumObject = valueOf.invoke(null, enumObjectName);
                            field.set(object, enumObject);
                        } else {
                            throw new IllegalArgumentException("Invalid value type: " + valueType);
                        }
                    } catch (NoSuchMethodException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
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
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                            break;
                        case "double":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(object, bigDecimal.doubleValue());
                            } else if (value instanceof Double doubleValue) {
                                field.set(object, doubleValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        case "short":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(object, bigDecimal.shortValue());
                            } else if (value instanceof Short shortValue) {
                                field.set(object, shortValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        case "long":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(object, bigDecimal.longValue());
                            } else if (value instanceof Long longValue) {
                                field.set(object, longValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        case "float":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(object, bigDecimal.floatValue());
                            } else if (value instanceof Float floatValue) {
                                field.set(object, floatValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                            break;
                        case "char":
                            if (value instanceof Character characterValue) {
                                field.set(object, characterValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        case "boolean":
                            if (value instanceof Boolean booleanValue) {
                                field.set(object, booleanValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        case "byte":
                            if (value instanceof Byte byteValue) {
                                field.set(object, byteValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                    }
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public static void configure(@NotNull Map<?, ?> map, @NotNull Class<?> type) {
        map.forEach((key, value) -> {
            try {
                // Field target
                Field field = type.getDeclaredField((String) key);

                // Access guaranteed
                field.setAccessible(true);

                // Object types
                Class<?> fieldType = field.getType();
                Class<?> valueType = value.getClass();

                // Complex object case
                if(value instanceof Map<?, ?> anotherMap) {
                    configure(anotherMap, field.get(type));
                }

                // Same class type case
                else if(fieldType == valueType) {
                    field.set(type, value);
                }

                // Enum class case
                else if(fieldType.isEnum()) {
                    try {
                        if(value instanceof String enumObjectName) {
                            Method valueOf = fieldType.getMethod("valueOf", String.class);
                            Object enumObject = valueOf.invoke(null, enumObjectName);
                            field.set(type, enumObject);
                        } else {
                            throw new IllegalArgumentException("Invalid value type: " + valueType);
                        }
                    } catch (NoSuchMethodException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
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
                else if(fieldType.isPrimitive()) {
                    String fieldTypeName = fieldType.getName();
                    switch (fieldTypeName) {
                        case "int":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(type, bigDecimal.intValue());
                            } else if (value instanceof Integer integerValue) {
                                field.set(type, integerValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                        case "double":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(type, bigDecimal.doubleValue());
                            } else if (value instanceof Double doubleValue) {
                                field.set(type, doubleValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                        case "short":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(type, bigDecimal.shortValue());
                            } else if (value instanceof Short shortValue) {
                                field.set(type, shortValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                        case "long":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(type, bigDecimal.longValue());
                            } else if (value instanceof Long longValue) {
                                field.set(type, longValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                        case "float":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(type, bigDecimal.floatValue());
                            } else if (value instanceof Float floatValue) {
                                field.set(type, floatValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                        case "char":
                            if (value instanceof Character characterValue) {
                                field.set(type, characterValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        case "boolean":
                            if (value instanceof Boolean booleanValue) {
                                field.set(type, booleanValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                        case "byte":
                            if (value instanceof Byte byteValue) {
                                field.set(type, byteValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                    }
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
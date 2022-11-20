package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

import java.lang.IllegalAccessException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Map;

public class RConfigurator implements InterfaceRConfigurator{

    private static RConfigurator instance;

    private RConfigurator() {}

    public static RConfigurator getInstance() {
        if(instance == null) {
            instance = new RConfigurator();
        } return instance;
    }

    @Override
    public void configure(@NotNull Map<?, ?> map, @NotNull Object object) {
        Class<?> objectType = object.getClass();
        map.forEach((key, value) -> {
            try {
                Field field = objectType.getDeclaredField((String) key);
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                Class<?> valueType = value.getClass();
                if(value instanceof Map<?, ?> anotherMap) {
                    configure(anotherMap, field.get(object));
                } else if (fieldType == valueType) {
                    field.set(object, value);
                } else if(fieldType.isEnum()) {
                    try {
                        if(value instanceof String enumObjectName) {
                            Method valueOf = fieldType.getMethod("valueOf", String.class);
                            Object enumObject = valueOf.invoke(null, enumObjectName);
                            field.set(object, enumObject);
                        } else {
                            throw new IllegalArgumentException("Invalid value type: " + valueType);
                        }
                    } catch (NoSuchMethodException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else if (fieldType.isPrimitive()) {
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
                            } break;
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
            } catch(NoSuchFieldException e) {
                throw new IllegalArgumentException();
            } catch(IllegalAccessException e) {
               e.printStackTrace();
                throw new juno.model.data.io.input.IllegalAccessException();
            }
        });
    }

    @Override
    public void configure(@NotNull Map<?, ?> map, @NotNull Class<?> clazz) {
        map.forEach((key, value) -> {
            try {
                Field field = clazz.getDeclaredField((String) key);
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                Class<?> valueType = value.getClass();
                if(value instanceof Map<?, ?> anotherMap) {
                    configure(anotherMap, field.get(clazz));
                } else if(fieldType == valueType) {
                    field.set(clazz, value);
                } else if(fieldType.isEnum()) {
                    try {
                        if(value instanceof String enumObjectName) {
                            Method valueOf = fieldType.getMethod("valueOf", String.class);
                            Object enumObject = valueOf.invoke(null, enumObjectName);
                            field.set(clazz, enumObject);
                        } else {
                            throw new IllegalArgumentException("Invalid value type: " + valueType);
                        }
                    } catch (NoSuchMethodException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }  else if(fieldType.isPrimitive()) {
                    String fieldTypeName = fieldType.getName();
                    switch (fieldTypeName) {
                        case "int":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(clazz, bigDecimal.intValue());
                            } else if (value instanceof Integer integerValue) {
                                field.set(clazz, integerValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                        case "double":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(clazz, bigDecimal.doubleValue());
                            } else if (value instanceof Double doubleValue) {
                                field.set(clazz, doubleValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                        case "short":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(clazz, bigDecimal.shortValue());
                            } else if (value instanceof Short shortValue) {
                                field.set(clazz, shortValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                        case "long":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(clazz, bigDecimal.longValue());
                            } else if (value instanceof Long longValue) {
                                field.set(clazz, longValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                        case "float":
                            if (value instanceof BigDecimal bigDecimal) {
                                field.set(clazz, bigDecimal.floatValue());
                            } else if (value instanceof Float floatValue) {
                                field.set(clazz, floatValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                        case "char":
                            if (value instanceof Character characterValue) {
                                field.set(clazz, characterValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        case "boolean":
                            if (value instanceof Boolean booleanValue) {
                                field.set(clazz, booleanValue);
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            } break;
                        case "byte":
                            if (value instanceof Byte byteValue) {
                                field.set(clazz, byteValue);
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
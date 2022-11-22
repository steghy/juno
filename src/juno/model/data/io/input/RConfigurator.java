package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

import java.lang.IllegalAccessException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Map;

public class RConfigurator
        implements InterfaceRConfigurator{

    private static RConfigurator instance;

    private RConfigurator() {}

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
            Object value = entry.getValue();

            Field field = objectType.getDeclaredField((String) key);

            field.setAccessible(true);

            Class<?> fieldType = field.getType();
            Class<?> valueType = value.getClass();

            if(Modifier.isStatic(field.getModifiers()) &&
                    Modifier.isFinal(field.getModifiers())) {
                continue;
            }

            if(value instanceof Map<?, ?> anotherMap) {
                if(!anotherMap.isEmpty())
                    configure(anotherMap, field.get(object));
            }

            else if(fieldType == valueType) {
                field.set(object, value);
            }

            else if(fieldType.isEnum()) {
                try {
                    if (value instanceof String enumObjectName) {
                        Method valueOf = fieldType.getMethod("valueOf", String.class);
                        Object enumObject = valueOf.invoke(null, enumObjectName);
                        field.set(object, enumObject);
                    } else {
                        throw new IllegalArgumentException("Invalid value type: " + valueType);
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }

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
                        } break;
                    case "double":
                        if (value instanceof BigDecimal bigDecimal) {
                            field.set(object, bigDecimal.doubleValue());
                        } else if (value instanceof Double doubleValue) {
                            field.set(object, doubleValue);
                        } else {
                            throw new IllegalArgumentException("Incompatible types:" +
                                    "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                        } break;
                    case "short":
                        if (value instanceof BigDecimal bigDecimal) {
                            field.set(object, bigDecimal.shortValue());
                        } else if (value instanceof Short shortValue) {
                            field.set(object, shortValue);
                        } else {
                            throw new IllegalArgumentException("Incompatible types:" +
                                    "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                        } break;
                    case "long":
                        if (value instanceof BigDecimal bigDecimal) {
                            field.set(object, bigDecimal.longValue());
                        } else if (value instanceof Long longValue) {
                            field.set(object, longValue);
                        } else {
                            throw new IllegalArgumentException("Incompatible types:" +
                                    "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                        } break;
                    case "float":
                        if (value instanceof BigDecimal bigDecimal) {
                            field.set(object, bigDecimal.floatValue());
                        } else if (value instanceof Float floatValue) {
                            field.set(object, floatValue);
                        } else {
                            throw new IllegalArgumentException("Incompatible types:" +
                                    "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                        } break;
                    case "char":
                        if (value instanceof Character characterValue) {
                            field.set(object, characterValue);
                        } else {
                            if(value instanceof String stringValue) {
                                if(stringValue.length() == 1) {
                                    field.set(object, stringValue.charAt(0));
                                }
                            } else {
                                throw new IllegalArgumentException("Incompatible types:" +
                                        "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                            }
                        } break;
                    case "boolean":
                        if (value instanceof Boolean booleanValue) {
                            field.set(object, booleanValue);
                        } else {
                            throw new IllegalArgumentException("Incompatible types:" +
                                    "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                        } break;
                    case "byte":
                        if (value instanceof Byte byteValue) {
                            field.set(object, byteValue);
                        } else {
                            throw new IllegalArgumentException("Incompatible types:" +
                                    "[Field type: " + fieldType + "], [Value type: " + valueType + "]");
                        } break;
                }
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
            Object value = entry.getValue();

            Field field = clazz.getDeclaredField((String) key);

            field.setAccessible(true);

            if(!Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            // NOT ALLOWED AT THE MOMENT
            if(Modifier.isFinal(field.getModifiers())) {
                continue;
            }

            Class<?> fieldType = field.getType();
            Class<?> valueType = value.getClass();

            if (value instanceof Map<?, ?> anotherMap) {
                if(!anotherMap.isEmpty()) {
                    configure(anotherMap, field.get(clazz));
                }
            }

            else if (fieldType == valueType) {
                field.set(clazz, value);
            }

            else if (fieldType.isEnum()) {
                try {
                    if (value instanceof String enumObjectName) {
                        Method valueOf = fieldType.getMethod("valueOf", String.class);
                        Object enumObject = valueOf.invoke(null, enumObjectName);
                        field.set(clazz, enumObject);
                    } else {
                        throw new IllegalArgumentException("Invalid value type: " + valueType);
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }

            else if (fieldType.isPrimitive()) {
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
                        } break;
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
        }
    }
}
package juno.model.data.io.input;

import juno.model.data.io.InterfaceDeepCopier;
import org.jetbrains.annotations.NotNull;

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
package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class PropertyCopier
        implements InterfacePropertyCopier {

    private static PropertyCopier instance;

    private PropertyCopier() {}

    public static PropertyCopier getInstance() {
        if(instance == null) instance = new PropertyCopier();
        return instance;
    }

    @Override
    public Map<String, Object> copy(@NotNull Object object) {
        Map<String, Object> map = new HashMap<>();
        for(Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if(!Modifier.isFinal(Modifier.fieldModifiers()))
                    map.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } return map;
    }

    @Override
    public Map<String, Object> copy(@NotNull Class<?> clazz) {
        Map<String, Object> map = new HashMap<>();
        for(Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if(Modifier.isStatic(field.getModifiers()))
                    if(!Modifier.isFinal(field.getModifiers()))
                        map.put(field.getName(), field.get(null));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } return map;
    }
}
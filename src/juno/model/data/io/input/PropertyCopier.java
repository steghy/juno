package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class PropertyCopier implements InterfacePropertyCopier {

    private static PropertyCopier instance;

    private PropertyCopier() {}

    public static PropertyCopier getInstance() {
        if(instance == null) instance = new PropertyCopier();
        return instance;
    }

    @Override
    public Map<String, Object> copy(@NotNull Object object) 
            throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        for(Field field : object.getClass().getDeclaredFields())
            if(!Modifier.isStatic(field.getModifiers()) && 
                    !Modifier.isFinal(field.getModifiers())) 
                map.put(field.getName(), field.get(object));
        return map;
    }
    
    @Override
    public Map<String, Object> copy(@NotNull Class<?> clazz)
            throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        for(Field field : clazz.getDeclaredFields())
            if(!Modifier.isStatic(field.getModifiers()) &&
                    !Modifier.isFinal(field.getModifiers()))
                map.put(field.getName(), field.get(clazz));
        return map;
    }
}
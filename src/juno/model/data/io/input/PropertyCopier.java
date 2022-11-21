package juno.model.data.io.input;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class PropertyCopier implements InterfacePropertyCopier {

    private static PropertyCopier instance;

    private PropertyCopier() {}

    public static PropertyCopier getInstance() {
        if(instance == null) {
            instance = new PropertyCopier();
        } return instance;
    }

    @Override
    public Map<String, Object> copy(Object object) throws IllegalAccessException {
        // FINAL FIELDS ????
        Map<String, Object> map = new HashMap<>();
        for(Field field : object.getClass().getDeclaredFields()) {
            map.put(field.getName(), field.get(object));
        } return map;
    }
}

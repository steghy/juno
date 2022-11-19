package juno.view.factories.buttons;

import juno.init.Directories;
import juno.init.Path;
import juno.model.data.io.input.AbstractDataImporter;
import juno.model.data.io.input.JSONDataImporter;
import juno.model.util.PathGenerator;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public class ReflectionClass {

    public static void applyReflection(Map<String, Object> map, Object object) {
        Class<?> objectType = object.getClass();
        map.forEach((key, value) -> {
            try {
                Field field = objectType.getDeclaredField(key);
                field.setAccessible(true);
                if (field.getType() == value.getClass()) {
                    field.set(object, value);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws IOException {
        String configDir = PathGenerator.generate(Directories.DATA.absolutePath(), "config");
        String configFile = PathGenerator.generate(configDir, "json-data-test.json");
        AbstractDataImporter dataImporter = JSONDataImporter.getInstance();
        Map<String, Object> map = dataImporter.importData(configFile);
        ReflectionTarget reflectionTarget = new ReflectionTarget();
        ReflectionClass.applyReflection(map, reflectionTarget);
        System.out.println("Field 1 is: " + reflectionTarget.getField1());
        System.out.println("Field 3 is: " + reflectionTarget.getField2());
        System.out.println("Field 3 is: " + reflectionTarget.getField3());
    }
}

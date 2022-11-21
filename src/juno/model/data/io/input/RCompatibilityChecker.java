package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class RCompatibilityChecker
        extends AbstractRCompatibilityChecker
        implements InterfaceRCompatibilityChecker{

    private static RCompatibilityChecker instance;

    private RCompatibilityChecker() {}

    public static RCompatibilityChecker getInstance() {
        if(instance == null) instance = new RCompatibilityChecker();
        return instance;
    }

    @Override
    public boolean checkCompatibilityOf(@NotNull Object object,
                                        @NotNull String path) {
        Map<String, Object> properties = getPropertyCopier().copy(object);
        boolean isValid = false;
        try {
            Map<String, Object> map = getDataImporter().importData(path);
            System.out.println(map);
            if(!map.isEmpty()) {
                getRConfigurator().configure(map, object);
                isValid = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            getRConfigurator().configure(properties, object);
        } catch (IllegalAccessException |
                 NoSuchFieldException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return isValid;
    }

    @Override
    public boolean checkCompatibilityOf(@NotNull Class<?> clazz,
                                        @NotNull String path) {
        Map<String, Object> properties = getPropertyCopier().copy(clazz);
        boolean isValid = false;
        try {
            Map<String, Object> map = getDataImporter().importData(path);
            if(!map.isEmpty()) {
                getRConfigurator().configure(map, clazz);
                isValid = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            getRConfigurator().configure(properties, clazz);
        } catch (IllegalAccessException |
                 NoSuchFieldException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return isValid;

    }
}
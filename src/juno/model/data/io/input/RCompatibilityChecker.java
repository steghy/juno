package juno.model.data.io.input;

import java.util.HashMap;
import java.util.Map;

public class RCompatibilityChecker extends AbstractRCompatibilityChecker implements InterfaceRCompatibilityChecker{

    private final Map<Object, String> objectIncompatibleFiles;
    private final Map<Class<?>, String> classIncompatibleFiles;

    private static RCompatibilityChecker instance;

    private RCompatibilityChecker() {
        objectIncompatibleFiles = new HashMap<>();
        classIncompatibleFiles = new HashMap<>();
    }

    public static RCompatibilityChecker getInstance() {
        if(instance == null) {
            instance = new RCompatibilityChecker();
        } return instance;
    }

    @Override
    public boolean checkCompatibilityOf(Object object, String path) {
        try {
            getRConfigurator().configure(getDataImporter().importData(path), object);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            objectIncompatibleFiles.put(object, path);
            return false;
        }
    }

    @Override
    public boolean checkCompatibilityOf(Class<?> clazz, String path) {
        try {
            getRConfigurator().configure(getDataImporter().importData(path), clazz);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            objectIncompatibleFiles.put(clazz, path);
            return false;
        }
    }

    public Map<Object, String> getObjectIncompatibleFiles() {
        return objectIncompatibleFiles;
    }

    public Map<Class<?>, String> getClassIncompatibleFiles() {
        return classIncompatibleFiles;
    }
}

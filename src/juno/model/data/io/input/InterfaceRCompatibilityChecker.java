package juno.model.data.io.input;

public interface InterfaceRCompatibilityChecker {

    boolean checkCompatibilityOf(Object object, String path);

    boolean checkCompatibilityOf(Class<?> clazz, String path);
}

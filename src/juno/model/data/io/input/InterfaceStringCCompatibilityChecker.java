package juno.model.data.io.input;

@FunctionalInterface
public interface InterfaceStringCCompatibilityChecker {

    boolean checkCompatibilityOf(Configurable configurable, String path);
}

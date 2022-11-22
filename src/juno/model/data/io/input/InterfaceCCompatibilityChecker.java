package juno.model.data.io.input;

@FunctionalInterface
public interface InterfaceCCompatibilityChecker {

    boolean checkCompatibilityOf(Configurable configurable, String path);
}

package juno.model.data.io.input;

import java.util.Map;

@FunctionalInterface
public interface InterfaceMapCCompatibilityChecker {

    boolean checkCompatibilityOf(Configurable configurable, Map<String, Object> map);
}

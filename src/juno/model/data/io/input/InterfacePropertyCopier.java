package juno.model.data.io.input;

import java.util.Map;

@FunctionalInterface
public interface InterfacePropertyCopier {

    Map<String, Object> copy(Object object) throws IllegalAccessException;
}

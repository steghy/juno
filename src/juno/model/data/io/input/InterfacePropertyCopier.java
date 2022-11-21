package juno.model.data.io.input;

import java.util.Map;

public interface InterfacePropertyCopier {

    Map<String, Object> copy(Object object);

    Map<String, Object> copy(Class<?> clazz);
}

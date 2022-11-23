package juno.model.data.io.input;

import java.util.Map;

public interface InterfaceDeepCopier {

    Map<String, Object> deepCopy(Object object);

    Map<String, Object> deepCopy(Class<?> clazz);
}

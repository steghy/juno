package juno.model.data.io.input;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface InterfaceRConfigurator {

    void configure(Map<?, ?> map, Object object) throws
            IllegalAccessException,
            NoSuchFieldException,
            InvocationTargetException;

    void configure(Map<?, ?> map, Class<?> clazz) throws
            IllegalAccessException,
            NoSuchFieldException,
            InvocationTargetException;
}

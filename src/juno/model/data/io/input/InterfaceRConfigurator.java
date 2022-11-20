package juno.model.data.io.input;

import java.util.Map;

public interface InterfaceRConfigurator {

    void configure(Map<?, ?> map, Object object) throws IllegalAccessException, NoSuchFieldException;

    void configure(Map<?, ?> map, Class<?> clazz) throws IllegalAccessException, NoSuchFieldException;
}

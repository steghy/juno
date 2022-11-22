package juno.model.data.io.input;

import java.util.Map;

@FunctionalInterface
public interface Configurable {

    void configure(Map<String, Object> map);
}

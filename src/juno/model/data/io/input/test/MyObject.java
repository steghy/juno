package juno.model.data.io.input.test;

import juno.model.data.io.input.Configurable;

import java.util.Map;

public class MyObject
        implements Configurable {

    private String value1 = "myObject string field";
    private int value2 = 999;
    private double value3 = 4.0;

    public MyObject() {}

    @Override
    public void configure(Map<String, Object> map) {

        if(map.containsKey("value1")) {
            if(map.get("value1") instanceof String val) {
                this.value1 = val;
            }
        }

    }
}

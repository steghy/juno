package juno.model.data.io.input.test;

import juno.model.data.io.input.Configurable;

import java.util.Map;

public class MyObject implements Configurable {

    private String value1 = "myObject string field";
    private int value2 = 999;
    private double value3 = 4.0;

    public MyObject() {}

    @Override
    public void configure(Map<String, Object> map) {
        if(map.containsKey("value1")) {
            if(map.get("value1") instanceof String temp) {
                this.value1 = temp;
            } else {
                throw new IllegalArgumentException(
                        "Invalid object type: " +
                                map.get("value1").getClass());
            }
        } else {
            throw new IllegalArgumentException("'value1' key not found in " + map);
        }

        if(map.containsKey("value1")) {
            if(map.get("value2") instanceof Integer temp) {
                this.value2 = temp;
            }
        } else {
            throw new IllegalArgumentException("'value1' key not found in " + map);
        }

        if(map.containsKey("value3")) {
            if(map.get("value1") instanceof Double temp) {
                this.value3 = temp;
            } else {
                throw new IllegalArgumentException(
                        "Invalid object type: " +
                                map.get("value1").getClass());
            }
        }
    }
}

package juno.model.data.io.input.test;

import juno.model.data.io.input.CCompatibilityChecker;
import juno.model.data.io.input.Configurable;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Map;

public class MyObject
        implements Configurable {

    private String value1 = "myObject string field";
    private Integer value2 = 999;
    private char value4 = 'a';
    private boolean value5 = true;
    private double value3 = 4.0;
    private long value6 = 45803L;
    private Dimension dimension = new Dimension(200, 400);
    private BigDecimal decimal = new BigDecimal(19);
    private CCompatibilityChecker cCompatibilityChecker = CCompatibilityChecker.getInstance();

    public MyObject() {}

    @Override
    public void configure(Map<String, Object> map) {}
}

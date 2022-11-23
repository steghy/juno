/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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

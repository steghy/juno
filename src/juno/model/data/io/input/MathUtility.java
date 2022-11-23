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

package juno.model.data.io.input;

import java.math.BigInteger;

public class MathUtility {

    private MathUtility() {}

    public static boolean isOutOfRange(String stringNumber, Class<?> clazz) {
        String min, max;

        if (clazz == Integer.class || clazz == int.class) {
            min = String.valueOf(Integer.MIN_VALUE);
            max = String.valueOf(Integer.MAX_VALUE);

        } else if (clazz == Double.class || clazz == double.class) {
            min = String.valueOf(Double.MIN_VALUE);
            max = String.valueOf(Double.MAX_VALUE);

        } else if (clazz == Float.class || clazz == float.class) {
            min = String.valueOf(Float.MIN_VALUE);
            max = String.valueOf(Float.MAX_VALUE);

        } else if (clazz == Long.class || clazz == long.class) {
            min = String.valueOf(Long.MIN_VALUE);
            max = String.valueOf(Long.MAX_VALUE);
        }

        else if (clazz == Short.class || clazz == short.class) {
            min = String.valueOf(Short.MIN_VALUE);
            max = String.valueOf(Short.MAX_VALUE);
        }

        else
            throw new IllegalArgumentException("Invalid Class type");

        BigInteger number = new BigInteger(stringNumber);
        BigInteger minNumber = new BigInteger(min);
        BigInteger maxNumber = new BigInteger(max);

        return number.compareTo(maxNumber) > 0 || number.compareTo(minNumber) < 0;
    }

    public static boolean isNumber(Class<?> clazz) {
        return  clazz == Integer.class || clazz == int.class    ||
                clazz == Double.class  || clazz == double.class ||
                clazz == Float.class   || clazz == float.class  ||
                clazz == Long.class    || clazz == long.class   ||
                clazz == Short.class   || clazz == short.class;
    }
}
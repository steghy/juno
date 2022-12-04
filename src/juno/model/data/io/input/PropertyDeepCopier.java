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

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


/**
 * This class defines a deep property copier of
 * an object. The copy method makes a copy
 * of the specified object using reflection.
 * Furthermore, the copy method is recursive
 * (For copying the data of an object not recursively
 * see the PropertyCopier class documentation).
 * @author Simone Gentili
 */
public class PropertyDeepCopier
        implements InterfacePropertyDeepCopier {

    /* The PropertyDeepCopier instance */
    private static PropertyDeepCopier instance;

    /* Builds the PropertyDeepCopier instance. */
    private PropertyDeepCopier() {}

    /**
     * Returns the PropertyDeepCopier instance.
     * @return The PropertyDeepCopier instance.
     */
    public static PropertyDeepCopier getInstance() {
        if (instance == null) instance = new PropertyDeepCopier();
        return instance;
    }

    @Override
    public Map<String, Object> deepCopy(@NotNull Object object) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();

        // Prevent the error of considering the fields of class 'Class'
        // in case the object passed in input was of type Class.
        Field[] fields = object instanceof Class<?> klass ? klass.getDeclaredFields() :
                object.getClass().getDeclaredFields();

        for(Field field : fields) {
                if(!Modifier.isFinal(field.getModifiers())) {

                    // It may throw an InaccessibleObjectException
                    // for some Java standard library classes.
                    field.setAccessible(true);

                    Class<?> fieldType = field.getType();

                    // Singleton class case. StackOverflow error
                    // without this check.
                    if(fieldType == object.getClass()) continue;

                    switch (fieldType.getSimpleName()) {

                        // Inspection for these values is unnecessary
                        // and would result in an exception
                        // (InaccessibleObjectException) anyway.
                        case    ("String"),
                                ("Integer"),   ("int"),
                                ("Double"),    ("double"),
                                ("Float"),     ("float"),
                                ("Short"),     ("short"),
                                ("Long"),      ("long"),
                                ("Character"), ("char"),
                                ("Byte"),      ("byte"),
                                ("Boolean"),   ("boolean")
                                -> map.put(field.getName(), field.get(object));

                        // BigDecimal to double.
                        case    ("BigDecimal")
                                -> map.put(field.getName(), ((BigDecimal)field.get(object)).doubleValue());

                        // BigInteger to int.
                        case    ("BigInteger")
                                -> map.put(field.getName(), ((BigInteger)field.get(object)).intValue());

                        // Recursive call to fetch the values from the object.
                        // Possible InaccessibleObjectException
                        default -> map.put(field.getName(), deepCopy(field.get(object)));
                    }
                }
        } return map;
    }

}
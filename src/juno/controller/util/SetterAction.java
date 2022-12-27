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

package juno.controller.util;

import juno.model.util.AbstractObservable;
import juno.model.util.InterfaceSetter;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Simone Gentili
 * @param <T> The type of the object.
 */
public class SetterAction<T>
        extends AbstractObservable
        implements ActionListener {

    // The graphic object.
    private final T object;

    // The setter.
    private final InterfaceSetter<T> setter;

    /**
     * Builds a SetterAction with the
     * specified object and setter.
     * @param object An Object.
     * @param setter An InterfaceSetter object.
     */
    public SetterAction(@NotNull T object,
                        @NotNull InterfaceSetter<T> setter) {
        this.object = object;
        this.setter = setter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setter.set(object);
    }

    /**
     * Returns the object to set.
     * @return An Object.
     */
    public T getObject() {
        return object;
    }

    /**
     * Returns the setter of this object.
     * @return An InterfaceSetter.
     */
    public InterfaceSetter<T> getSetter() {
        return setter;
    }

}

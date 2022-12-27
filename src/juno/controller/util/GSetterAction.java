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

import juno.model.util.InterfaceSetter;
import juno.view.gobject.InterfaceGObject;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Simone Gentili
 */
public class GSetterAction<T>
        implements ActionListener {

    // The graphic object.
    private final InterfaceGObject<T> gObject;

    // The setter.
    private final InterfaceSetter<T> setter;

    /**
     * Builds a SetterAction object with the specified
     * graphic object and setter objects.
     * @param gObject An InterfaceGObject object.
     * @param setter An InterfaceSetter object.
     */
    public GSetterAction(@NotNull InterfaceGObject<T> gObject,
                         @NotNull InterfaceSetter<T> setter) {
        this.gObject = gObject;
        this.setter = setter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setter.set(gObject.object());
    }

}
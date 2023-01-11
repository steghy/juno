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

package juno.view.img_initializer;

import juno.model.requester.InterfacePathProvider;
import juno.view.util.RotatedIcon;

import javax.swing.*;

/**
 * This interface defines abstract
 * button initializers.
 * @author Simone Gentili
 */
@FunctionalInterface
public interface InterfaceAbstractButtonInitializer {

    /**
     * Initialize the specified AbstractButton object
     * with the specified parameters.
     * @param button An AbstractButton object.
     * @param file An InterfacePathProvider object.
     * @param rolloverFiler An InterfacePathProvider object.
     * @param rotate A RotatedIcon.Rotate object.
     */
    void initialize(AbstractButton button,
                    InterfacePathProvider file,
                    InterfacePathProvider rolloverFiler,
                    RotatedIcon.Rotate rotate);

}
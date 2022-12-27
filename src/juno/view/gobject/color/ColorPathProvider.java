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

package juno.view.gobject.color;

import juno.model.card.colors.InterfaceColor;
import juno.model.requester.InterfacePathProvider;
import juno.model.requester.ProgramDirectory;
import juno.view.gobject.InterfacePathObjectProvider;

/**
 * @author Simone Gentili
 */
public class ColorPathProvider
        implements InterfacePathObjectProvider<InterfaceColor> {

    // The ColorPathProvider instance.
    private static ColorPathProvider instance;

    // Builds the ColorPathProvider instance.
    private ColorPathProvider() {}

    /**
     * Returns the ColorPathProvider instance.
     * @return The ColorPathProvider instance.
     */
    public static ColorPathProvider getInstance() {
        if(instance == null) instance = new ColorPathProvider();
        return instance;
    }

    @Override
    public InterfacePathProvider getPathObjectOf(InterfaceColor object) {
        return ProgramDirectory.COLORS;
    }

}

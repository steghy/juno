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

package juno.view.button;

import juno.init.InterfacePathProvider;
import juno.init.PathProvider;
import juno.view.gobject.InterfacePathObjectProvider;

public class ButtonDirectoryPathProvider
        implements InterfacePathObjectProvider<InterfaceButton> {

    // The ButtonDirectoryPathProvider instance.
    private static ButtonDirectoryPathProvider instance;

    // Builds the DirectoryPathProvider instance.
    private ButtonDirectoryPathProvider() {}

    /**
     * Returns the ButtonDirectoryPathProvider instance.
     * @return The ButtonDirectoryPathProvider instance.
     */
    public static ButtonDirectoryPathProvider getInstance() {
        if(instance == null) instance = new ButtonDirectoryPathProvider();
        return instance;
    }

    @Override
    public InterfacePathProvider getPathObjectOf(InterfaceButton card) {
        return PathProvider.BUTTONS;
    }
}

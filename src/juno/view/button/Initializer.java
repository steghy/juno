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

import juno.view.download.ImageComponentInitializer;
import juno.view.download.PathObjectAssembler;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    /** Initialize the juno.view.button package. */
    public static void initialize() {
        // Component.
        // ButtonCreator.
        ButtonCreator buttonCreator = ButtonCreator.getInstance();

        // ImageComponentInitializer.
        ImageComponentInitializer imageComponentInitializer = ImageComponentInitializer.getInstance();

        // PathObjectAssembler.
        PathObjectAssembler pathObjectAssembler = PathObjectAssembler.getInstance();

        // ButtonDirectoryPathProvider.
        ButtonDirectoryPathProvider buttonDirectoryPathProvider = ButtonDirectoryPathProvider.getInstance();


        buttonCreator.setInitializer(imageComponentInitializer);
        buttonCreator.setAssembler(pathObjectAssembler);
        buttonCreator.setProvider(buttonDirectoryPathProvider);
    }

}
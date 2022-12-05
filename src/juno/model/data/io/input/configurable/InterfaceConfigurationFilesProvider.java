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

package juno.model.data.io.input.configurable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * This interface defines a method for obtaining
 * configuration files for a specified object.
 * @author Simone Gentili
 */
@FunctionalInterface
public interface InterfaceConfigurationFilesProvider {

    /**
     * Returns a list containing the configuration
     * files compatible with the specified Configurable
     * object present within the specified path.
     * @param configurable A Configurable object.
     * @param path A String object.
     * @return A List object.
     * @throws FileNotFoundException If the specified
     *         path does not exist.
     */
    List<File> getConfigurationFiles(Configurable configurable,
                                     String path)
            throws FileNotFoundException;

}
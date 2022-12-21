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

package juno.controller.pre_access.log_in.path_builders;

import juno.controller.pre_access.log_in.InterfacePathBuilder;
import juno.controller.pre_access.log_in.name_builders.InterfaceFileNameBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Simone Gentili
 */
public abstract class AbstractPathBuilder
        implements InterfacePathBuilder {

    // The file name builder.
    private InterfaceFileNameBuilder builder;

    // Directory.
    private String directory;

    /**
     * Sets the file name builder of this object.
     * @param builder An InterfaceFileNameBuilder object.
     */
    public void setBuilder(@NotNull InterfaceFileNameBuilder builder) {
        this.builder = builder;
    }

    /**
     * Sets the directory path of this object.
     * @param directory A String object.
     */
    public void setDirectory(@NotNull String directory) {
        this.directory = directory;
    }

    /**
     * Returns the file name builder of this object.
     * @return An InterfaceFileNameBuilder object.
     */
    @Nullable
    public InterfaceFileNameBuilder getBuilder() {
        return builder;
    }

    /**
     * Returns the directory of this object.
     * @return A String object.
     */
    @Nullable
    public String getDirectory() {
        return directory;
    }

}
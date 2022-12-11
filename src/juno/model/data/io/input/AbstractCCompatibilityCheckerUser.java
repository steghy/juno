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

import juno.model.data.io.input.configurable.InterfaceCCompatibilityChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Simone Gentili
 */
public class AbstractCCompatibilityCheckerUser {

    // The compatibility checker for Configurable object.
    private InterfaceCCompatibilityChecker checker;

    /**
     * Sets the compatibility checker for Configurable
     * object of this object.
     * @param checker An InterfaceCCompatibilityChecker object.
     */
    public void setChecker(@NotNull InterfaceCCompatibilityChecker checker) {
        this.checker = checker;
    }

    /**
     * Returns the compatibility checker for Configurable
     * object of this object.
     * @return An InterfaceCCompatibilityChecker object.
     */
    @Nullable
    public InterfaceCCompatibilityChecker getChecker() {
        return checker;
    }
}